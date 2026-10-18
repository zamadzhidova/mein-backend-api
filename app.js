const http = require('http');

// AWS Elastic Beanstalk nutzt standardmäßig Port 8080 für Node.js
const port = process.env.PORT || 8080;

const server = http.createServer((req, res) => {
  res.statusCode = 200;
  res.setHeader('Content-Type', 'text/plain');
  res.end('Hallo Welt! Meine allererste Node.js-API laeuft live und gruen auf AWS!');
});

server.listen(port, () => {
  console.log(`Server laeuft auf Port ${port}`);
});
