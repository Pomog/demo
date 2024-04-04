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