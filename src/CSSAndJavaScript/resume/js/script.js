
const body = document.body;
const photo = document.getElementById("photo");

const shake1 = "shake1";
const shake2 = "shake2";

function shakeBody() {
    body.classList.add(shake1);
    shakePhoto();

    setTimeout(function () {
        body.classList.remove(shake1);
        photo.classList.remove(shake2);
    }, 200);
}

function shakePhoto() {
    photo.classList.add(shake2);
}

function discover(){
    console.log("navigator")
    console.log(navigator.userAgent); // Browser's user agent string

    console.log(navigator)
    for (let key in navigator) {
        console.log(key);
    }
}
discover();

async function fetchData() {
    try {
        const response = await fetch('https://www.7timer.info/bin/astro.php?lon=26&lat=58&ac=0&lang=en&unit=metric&output=internal&tzshift=0');


        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        const res = await response;
        for (let key in res) {
            console.log(key)
            console.log(res[key])
        }
    } catch (error) {
        console.error('Error fetching data:', error);
    }
}
