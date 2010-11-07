var sys = require('sys');
var obj = {
    name: "Tom Hanks",
    age: 54,
};

sys.print("Print message.\n");
sys.log('Log message.');
sys.print(sys.inspect(obj)+"\n");

