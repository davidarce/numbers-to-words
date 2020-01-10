# Numbers-to-Words
A Java web program to transform numbers into word equivalents

## Technologies
- Java 11

## Prerequisites
- Java 11
- Maven

## How to use

#### Clone the repository
```
git clone https://github.com/davidarce/numbers-to-words.git   
cd numbers-to-words
```

#### Run the application
```
mvn clean package spring-boot:repackage
java -jar target/numbers-to-words.jar

The application can be accessed through the following URL:
http://localhost:8080/convert
```
### Basic examples

```
Input 5
Five
```

```
Input 0
Zero
```

```
Input 13
Thirteen
```

```
Input 85
Eighty five
```

```
Input 5237
Five thousand two hundred and thirty seven
```

##### Negative numbers examples

```
Input -2000
Negative two thousand
```

```
Input -2147483648
Negative two billion one hundred forty seven million four hundred eighty three thousand six hundred and forty eight
```

##### Invalid numbers examples

```
Input Hello world
Invalid number, enter a number between –2,147,483,648 and 2,147,483,647
```

```
Input 23232323728478374837483
Invalid number, enter a number between –2,147,483,648 and 2,147,483,647
```



