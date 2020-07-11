# spring-security-jwt-example

git clone https://github.com/hong1234/spring-security-jwt-example.git

cd spring-security-jwt-example

///////////// run in normal Mode ////////////////////////

mvn spring-boot:run

////////////run in Docker containers/////////////////////

// build Image “hong/spring-security-jwt-example”
sudo docker build -t hong/spring-security-jwt-example .

// run containers
sudo docker-compose up


/////////////get jwt-Token/////////////////////
POST localhost:8000/authenticate
Body raw json
{
"userName":"hong",
"password":"vuanh"
}
→ user ...token

POST localhost:8000/authenticate
Body raw json
{
"userName":"hong2",
"password":"vuanh2"
}
→ user-admin ...token

///////////postman-client access using token /////////

GET localhost:8000/
GET localhost:8000/admin

Authorization Bearer Token  xxxxxxxxxxxxxxxxxx
