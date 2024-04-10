package interview;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
    
    public class URLShorter {
        private final URL baseUrl;
        private final MessageDigest messageDigest;
        private final Map<String, String> urlsMap = new ConcurrentHashMap<>();
        private final java.util.Base64.Encoder base64Encoder = Base64.getUrlEncoder();
        private final int shortLength;
        
        public URLShorter(String baseUrl, String hashAlgorithm, int shortLength) throws MalformedURLException, NoSuchAlgorithmException {
            this.baseUrl = URI.create(baseUrl).toURL(); // validate
            messageDigest = MessageDigest.getInstance(hashAlgorithm);
            
            // base64 is bigger at least by 33%
            if (messageDigest.getDigestLength() * 1.33 < shortLength) {
                throw new IllegalArgumentException("short length argument is too big");
            }
            this.shortLength = shortLength;
        }
        
        public String shortUrlOf(String longURL) {
            var shortURL = urlsMap.computeIfAbsent(longURL, this::makeShortUrl);
            urlsMap.put(shortURL, longURL);
            return shortURL;
        }
        
        public String longUrlOf(String shortURL) {
            return urlsMap.get(shortURL);
        }
        
        private String makeShortUrl(String url) {
            var shortId = base64Encoder.encodeToString(messageDigest.digest(url.getBytes(StandardCharsets.UTF_8))).substring(0, shortLength);
            
            String shortURL;
            try {
                shortURL = baseUrl.toURI().resolve(shortId).toString();
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
            
            return shortURL;
        }
        
        public static void main(String[] args) throws Exception {
            var shorter = new URLShorter("https://sho.rt", "SHA1", 8);
            
            var shortURL = shorter.shortUrlOf("https://www.youtube.com/watch?v=XwHHqkgQT-Y");
            System.out.printf("%s\t<==> %s%n", shorter.longUrlOf(shortURL), shortURL);
            
            shortURL = shorter.shortUrlOf("https://www.youtube.com/shorts/XwHHqkgQT-Y");
            System.out.printf("%s\t<==> %s%n", shorter.longUrlOf(shortURL), shortURL);
            
            shortURL = shorter.shortUrlOf("https://www.youtube.com/watch?v=l9nh1l8ZIJQ");
            System.out.printf("%s\t<==> %s%n", shorter.longUrlOf(shortURL), shortURL);
        }
    }

