function f() {
    console.log("Hello, world form java");
    if (document.getElementById("tag1")) {
        document.getElementById("tag1").innerHTML = "Content updated";
    }
};
// Self invoking functions
// This pattern is highly used in frameworks

setTimeout(f, 2000)

