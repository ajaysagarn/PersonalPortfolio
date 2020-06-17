import express from 'express'
import bodyParser from 'body-parser'
import path from 'path'


const app = express();
const rootHtml = path.join(__dirname,'../public', 'index.html')

app.use(express.static(path.join(__dirname, '../public')));

app.get('/ping', function (req, res) {
 return res.send('pong');
});

app.get('/', function (req, res) {
    console.log(rootHtml)
    res.sendFile(rootHtml);
});

app.listen(process.env.PORT || 8080);