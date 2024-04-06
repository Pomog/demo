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

function saveNameToLocalStorage(id){
    let projects = localStorage.getItem('ClickedProject:').toString() + ` | ` + id.toString();
    localStorage.setItem('ClickedProject:', projects);
}

/**
 * IIFE. Retrieves the current geographical position and stores latitude and longitude in localStorage.
 */
(function() {
    console.log(this);
    console.log(navigator);

    // Get the current geographical position
    navigator.geolocation.getCurrentPosition(
        function(position) {
            // Store latitude and longitude in localStorage
            localStorage.setItem('Latitude:', position.coords.latitude.toString());
            localStorage.setItem('Longitude:', position.coords.longitude.toString());
        },
        function(error) {
            // If there's an error, store the error message in localStorage
            localStorage.setItem('Error getting geolocation:', error.message);
        }
    );
})();

/**
 * Sends the data from Window.localStorage to the server endpoint using fetch.
 */
async function sendDataToServer(endpoint) {
    try {
        await fetch(endpoint, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(localStorage)
        });

        console.log('Data sent to server successfully');
    } catch (error) {
        console.error('Error sending data to server:', error);
    }
}


