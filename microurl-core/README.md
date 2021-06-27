# Sample API call

1. API for creating Short URL

Request:
URL: http://localhost:8080/url
METHOD: POST
PAYLOAD: 
{
	“userId”: “user id”,
	“email”: “example@xyz.com”
	“longUrl”: “www.facebook.com”
}

Response:
if Successful 
STATUS: 200
DATA: 
{
	“userId”: “user id”,
	“email”: “example@xyz.com”
	“longUrl”: “www.facebook.com”	
	“shortUrl”: “http://localhost/74adrbdr”
}

2. API for listing all the short urls by user

Request:
URL: http://localhost:8080/urls
METHOD: GET
PAYLOAD: 
{
	“userId”: “user id”
	“cursor”: 0
}

Response:
STATUS: 200
DATA:
{
	urls: [
		{“shortUrl”: “xyz”, longUrl: “facebook.com”},
		{“shortUrl”: “abc”, longUrl: “google.com”},
	]
	hasMore: true
}

