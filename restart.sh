mvn clean package docker:build -DpushImage
docker build -t mn-http-server .
docker run -p 80:80 --rm -d mn-http-server
