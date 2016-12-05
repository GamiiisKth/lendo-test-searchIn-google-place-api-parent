1) 
check that you have installed maven  on your computer

if yes jump(3)

if no 
run the following command 
2)
brew update 
brew install maven 

3) 
run the following command  to build all projects

./execute.sh build

4) 

cd lendo-test-searchIn-google-place-api-parent/lendo-endpoint-searchIn-googlePlace/lendo-endpoint-searchIn-googlePlace-development

5)
start jetty server

mvn jetty:run

6)

paste the following url into your browser 

http://localhost:8029/i10/api/v1/docs/index.html
 

