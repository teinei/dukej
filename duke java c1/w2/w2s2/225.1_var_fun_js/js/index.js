//225.1 variables, methods and functions
//creating and initializing 3 variables
var x = 3;
var y =4;
var z = x+2*y;

//print values
var x =3;
var y=2;
y=x;
//3 print functions
window.alert(x+"\n"+y);
document.write(x+"<br>"+y);
document.getElementById("var").innerHTML = x+"<br>"+y;

//function
function square(x){
    var ans = x*x;
    return ans;
}

var y = square(4);
document.getElementById("fun").innerHTML = y;





var image = null;

function upload() {
  //Get input from file input
  var fileinput = document.getElementById("finput");
  //Make new SimpleImage from file input
  image = new SimpleImage(fileinput);
  //Get canvas
  var canvas = document.getElementById("can");
  //Draw image on canvas
  image.drawTo(canvas);
}

function makeGray() {
  //change all pixels of image to gray
  for (var pixel of image.values()) {
    var avg = (pixel.getRed()+pixel.getGreen()+pixel.getBlue())/3;
    pixel.setRed(avg);
    pixel.setGreen(avg);
    pixel.setBlue(avg);
  }
  //display new image
  var canvas = document.getElementById("can");
  image.drawTo(canvas);
}