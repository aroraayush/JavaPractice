const assert = require('assert')
// Constant paramters
const hostname = '127.0.0.1'
const port = 3000
const URL = 'http://127.0.0.1:3000/sample/1?name=ayush'
const POSTData = {name: "ayush"}

// creating the server
const server = createServer().listen(port)
// const server = createServer()

// // initializing the server
// server.listen(port, hostname, () => {
//     console.log(`Server running at http://${hostname}:${port}/`)
// })


function createServer(){

    const http = require('http')
    const url = require('url')

    const server = http.createServer((req, res) => {

        const reqUrl = url.parse(req.url, true)
        let pathname = reqUrl.pathname
        let endpoint = pathname.substring(0, pathname.indexOf('/',2))
        if(!endpoint.length)
            endpoint = pathname

        const reqParamaters = reqUrl.pathname.split('/')
        reqParamaters.splice(0,2)

        // GET Endpoints
        if(req.method === 'GET'){
            if(endpoint === '/sample'){
                if(reqParamaters.length > 0){
                    res.writeHead(200, { 'Content-Type': 'text/plain' })
                    res.end(`id sent ${reqParamaters[0]}`)
                }
                else {
                    res.writeHead(200, { 'Content-Type': 'text/plain' })
                    res.end('response sent')
                }
            }
            else{
                sendNotFound(reqUrl, res)
            }
        }
        else if(req.method === 'POST'){
            if(endpoint === '/sample'){

                let body = '';
                req.on('data', chunk => {
                    body += chunk.toString(); // convert Buffer to string
                });
                req.on('end', () => {
                    console.log("body", body);
                    res.end('ok');
                });
            }
            else{
                sendNotFound(reqUrl, res)
            }
        }
        else{
            sendNotFound(reqUrl, res)
        }

    });
    return server
}

function sendNotFound(reqUrl, res){
    res.writeHead(404, { 'Content-Type': 'text/plain' })
    res.end("end point not found "+reqUrl.pathname)
}

async function getRequests(url){
    try{

        console.log("GET called")
        const res = await fetch(url)
        const resText = await res.text()
        console.log('data received (GET) :', resText);
        assert.notEqual(resText, 'response sent')
    }
    catch(e){
        console.log('Exception :' ,e);
    }
}

getRequests(URL)

postRequests(URL, POSTData)

async function postRequests(url, data){
    try{

        const options = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        }

        const response = await fetch(url, options);
        const resText = await response.text()
        console.log('\nReceived respoonse for URL :',url);
        console.log('data received (POST) :', resText);
    }
    catch(e){
        console.error('Error:', e);
    }
}





