const express = require("express");

const app = express();

app.use(express.static('public'));

const PORT = 8080; // Default port for http protocol
// for https 443 is default
app.listen(PORT, () => {
    console.log(`Server listening on http://localhost:${PORT}`);
})