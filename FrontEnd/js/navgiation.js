let latitude;
let longitude;
navigator.geolocation.getCurrentPosition((position)=>{
    console.log('longitude=',position.coords.longitude);
    longitude=position.coords.longitude
    console.log('latitude=',position.coords.latitude);
    latitude=position.coords.latitude
});