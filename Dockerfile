# define base docker image
FROM openjdk:17
ADD target/CoffeeShopWebApplication-0.0.1-SNAPSHOT.jar coffeeshop-image.jar
ENTRYPOINT ["java", "-jar" ,"coffeeshop-image.jar"]
