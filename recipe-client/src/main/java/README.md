# openapi-java-client

Yokudlela Recipes/Menus API
- API version: v1
  - Build date: 2023-05-27T01:43:22.861654500+02:00[Europe/Budapest]

description = \"Yokudlela Recipes/Tables API for Graphical User Interface .


*Automatically generated by the [OpenAPI Generator](https://openapi-generator.tech)*


## Requirements

Building the API client library requires:
1. Java 1.8+
2. Maven (3.8.3+)/Gradle (7.2+)

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn clean install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn clean deploy
```

Refer to the [OSSRH Guide](http://central.sonatype.org/pages/ossrh-guide.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>org.openapitools</groupId>
  <artifactId>openapi-java-client</artifactId>
  <version>v1</version>
  <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
  repositories {
    mavenCentral()     // Needed if the 'openapi-java-client' jar has been published to maven central.
    mavenLocal()       // Needed if the 'openapi-java-client' jar has been published to the local maven repo.
  }

  dependencies {
     implementation "org.openapitools:openapi-java-client:v1"
  }
```

### Others

At first generate the JAR by executing:

```shell
mvn clean package
```

Then manually install the following JARs:

* `target/openapi-java-client-v1.jar`
* `target/lib/*.jar`

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

// Import classes:
import yokudlela.recipe.java.clients.invoker.ApiClient;
import yokudlela.recipe.java.clients.invoker.ApiException;
import yokudlela.recipe.java.clients.invoker.Configuration;
import yokudlela.recipe.java.clients.invoker.auth.*;
import yokudlela.recipe.java.clients.invoker.models.*;
import yokudlela.recipe.java.clients.api.MenuControllerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080/recipe");
    
    MenuControllerApi apiInstance = new MenuControllerApi(defaultClient);
    String name = "name_example"; // String | Term�k neve
    Double quantity = 3.4D; // Double | Mennyis�g
    String unit = "unit_example"; // String | M�rt�kegys�g
    try {
      Product result = apiInstance.addConsumer(name, quantity, unit);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MenuControllerApi#addConsumer");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

## Documentation for API Endpoints

All URIs are relative to *http://localhost:8080/recipe*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*MenuControllerApi* | [**addConsumer**](docs/MenuControllerApi.md#addConsumer) | **POST** /menu/add/product | �j term�k felvitele
*MenuControllerApi* | [**getLowQuantityProducts**](docs/MenuControllerApi.md#getLowQuantityProducts) | **GET** /menu/getLowQuantityProducts | Azon term�kek lek�rdez�se, amelyek a megadott m�rt�kegys�get (G, KG, PCS, L, ML) haszn�lj�k �s a param�terk�nt �tadott mennyis�gn�l (pl. 100) kevesebb van bel?l�k rakt�ron.
*MenuControllerApi* | [**getMenusByDayOfWeek**](docs/MenuControllerApi.md#getMenusByDayOfWeek) | **GET** /menu/getMenusByDayOfWeek | Azon men�k lek�rdez�se, amelyek a param�terk�nt �tadott napon (a h�t napjai k�z�l) el�rhet?ek. pl. MONDAY
*MenuControllerApi* | [**getMenusByGroupId**](docs/MenuControllerApi.md#getMenusByGroupId) | **GET** /menu/getMenusByGroupId | Azon men�k lek�rdez�se, amelyek a param�terk�nt �tadott csoportazonos�t�val rendelkeznek. (pl. 300, 303 stb)
*MenuControllerApi* | [**getMostFrequentlyOrderedMenuItem**](docs/MenuControllerApi.md#getMostFrequentlyOrderedMenuItem) | **GET** /menu/getMostFrequentlyOrderedMenuItem | Legt�bbsz�r rendelt �tel lek�rdez�se.
*MenuControllerApi* | [**getRecipesWithEnoughResources**](docs/MenuControllerApi.md#getRecipesWithEnoughResources) | **GET** /menu/getRecipesWithEnoughResources | Azon receptek lek�rdez�se, amelyekhez VAN elegend? alapanyag rakt�ron.
*MenuControllerApi* | [**getRecipesWithNotEnoughResources**](docs/MenuControllerApi.md#getRecipesWithNotEnoughResources) | **GET** /menu/getRecipesWithNotEnoughResources | Azon receptek lek�rdez�se, amelyekhez NINCS elegend? alapanyag rakt�ron.


## Documentation for Models

 - [Ingredient](docs/Ingredient.md)
 - [Menu](docs/Menu.md)
 - [MenuGroup](docs/MenuGroup.md)
 - [MenuItem](docs/MenuItem.md)
 - [Product](docs/Product.md)
 - [Recipe](docs/Recipe.md)


## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author

gaalruben02@gmail.com
