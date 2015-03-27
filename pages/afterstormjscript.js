/*
*Attempts at JavaScript!
*/

var images = [
    {
        subtitle : 'Subtitle text for image one...',
        src : 'tornado1.jpg'
    },
    {
        subtitle : 'Subtitle text for image two...',
        src : 'tornado2.jpg'
    },
    {
        subtitle : 'Subtitle text for image three...',
        src : 'tornado3.jpg'
    }
];

function setBackground (images) {
    // generates a random integer between 0 and the length of the supplied array:
    var n = Math.floor(Math.random() * images.length),

    // sets the background-image of the 'body' element:
    //document.body.style.backgroundImage = 'url(' + images[n].src + ')';
	var divtornado = document.getElementById('tornadopic');
	divtornado.style.backgroundImage = 'url(' + images[n].src + ')';
}

setBackground(images);

