function foo(param1) {
  console.log("Normal function:", arguments);
  
}

foo("something");

var arrowFun = (param1) => {
  console.log("arguments", arguments);
}

arrowFun("something");
