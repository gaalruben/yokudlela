# MenuControllerApi

All URIs are relative to *http://localhost:8080/recipe*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**addConsumer**](MenuControllerApi.md#addConsumer) | **POST** /menu/add/product | �j term�k felvitele |
| [**getLowQuantityProducts**](MenuControllerApi.md#getLowQuantityProducts) | **GET** /menu/getLowQuantityProducts | Azon term�kek lek�rdez�se, amelyek a megadott m�rt�kegys�get (G, KG, PCS, L, ML) haszn�lj�k �s a param�terk�nt �tadott mennyis�gn�l (pl. 100) kevesebb van bel?l�k rakt�ron. |
| [**getMenusByDayOfWeek**](MenuControllerApi.md#getMenusByDayOfWeek) | **GET** /menu/getMenusByDayOfWeek | Azon men�k lek�rdez�se, amelyek a param�terk�nt �tadott napon (a h�t napjai k�z�l) el�rhet?ek. pl. MONDAY |
| [**getMenusByGroupId**](MenuControllerApi.md#getMenusByGroupId) | **GET** /menu/getMenusByGroupId | Azon men�k lek�rdez�se, amelyek a param�terk�nt �tadott csoportazonos�t�val rendelkeznek. (pl. 300, 303 stb) |
| [**getMostFrequentlyOrderedMenuItem**](MenuControllerApi.md#getMostFrequentlyOrderedMenuItem) | **GET** /menu/getMostFrequentlyOrderedMenuItem | Legt�bbsz�r rendelt �tel lek�rdez�se. |
| [**getRecipesWithEnoughResources**](MenuControllerApi.md#getRecipesWithEnoughResources) | **GET** /menu/getRecipesWithEnoughResources | Azon receptek lek�rdez�se, amelyekhez VAN elegend? alapanyag rakt�ron. |
| [**getRecipesWithNotEnoughResources**](MenuControllerApi.md#getRecipesWithNotEnoughResources) | **GET** /menu/getRecipesWithNotEnoughResources | Azon receptek lek�rdez�se, amelyekhez NINCS elegend? alapanyag rakt�ron. |


<a name="addConsumer"></a>
# **addConsumer**
> Product addConsumer(name, quantity, unit)

�j term�k felvitele

### Example
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
    defaultClient.setBasePath("http://recipe:8080/recipe");
    
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

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **name** | **String**| Term�k neve | |
| **quantity** | **Double**| Mennyis�g | |
| **unit** | **String**| M�rt�kegys�g | |

### Return type

[**Product**](Product.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Sikeres felvitel |  -  |

<a name="getLowQuantityProducts"></a>
# **getLowQuantityProducts**
> List&lt;Product&gt; getLowQuantityProducts(quantity, unit)

Azon term�kek lek�rdez�se, amelyek a megadott m�rt�kegys�get (G, KG, PCS, L, ML) haszn�lj�k �s a param�terk�nt �tadott mennyis�gn�l (pl. 100) kevesebb van bel?l�k rakt�ron.

### Example
```java
// Import classes:
import yokudlela.recipe.java.clients.invoker.ApiClient;
import yokudlela.recipe.java.clients.invoker.ApiException;
import yokudlela.recipe.java.clients.invoker.Configuration;
import yokudlela.recipe.java.clients.invoker.models.*;
import yokudlela.recipe.java.clients.api.MenuControllerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080/recipe");

    MenuControllerApi apiInstance = new MenuControllerApi(defaultClient);
    Double quantity = 3.4D; // Double | Maxim�lis mennyis�g
    String unit = "unit_example"; // String | M�rt�kegys�g
    try {
      List<Product> result = apiInstance.getLowQuantityProducts(quantity, unit);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MenuControllerApi#getLowQuantityProducts");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **quantity** | **Double**| Maxim�lis mennyis�g | |
| **unit** | **String**| M�rt�kegys�g | |

### Return type

[**List&lt;Product&gt;**](Product.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Sikeres lek�rdez�s |  -  |

<a name="getMenusByDayOfWeek"></a>
# **getMenusByDayOfWeek**
> List&lt;Menu&gt; getMenusByDayOfWeek(dayOfWeek)

Azon men�k lek�rdez�se, amelyek a param�terk�nt �tadott napon (a h�t napjai k�z�l) el�rhet?ek. pl. MONDAY

### Example
```java
// Import classes:
import yokudlela.recipe.java.clients.invoker.ApiClient;
import yokudlela.recipe.java.clients.invoker.ApiException;
import yokudlela.recipe.java.clients.invoker.Configuration;
import yokudlela.recipe.java.clients.invoker.models.*;
import yokudlela.recipe.java.clients.api.MenuControllerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080/recipe");

    MenuControllerApi apiInstance = new MenuControllerApi(defaultClient);
    String dayOfWeek = "dayOfWeek_example"; // String | A h�t egy napja angolul
    try {
      List<Menu> result = apiInstance.getMenusByDayOfWeek(dayOfWeek);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MenuControllerApi#getMenusByDayOfWeek");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **dayOfWeek** | **String**| A h�t egy napja angolul | |

### Return type

[**List&lt;Menu&gt;**](Menu.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Sikeres lek�rdez�s |  -  |

<a name="getMenusByGroupId"></a>
# **getMenusByGroupId**
> List&lt;Menu&gt; getMenusByGroupId(groupId)

Azon men�k lek�rdez�se, amelyek a param�terk�nt �tadott csoportazonos�t�val rendelkeznek. (pl. 300, 303 stb)

### Example
```java
// Import classes:
import yokudlela.recipe.java.clients.invoker.ApiClient;
import yokudlela.recipe.java.clients.invoker.ApiException;
import yokudlela.recipe.java.clients.invoker.Configuration;
import yokudlela.recipe.java.clients.invoker.models.*;
import yokudlela.recipe.java.clients.api.MenuControllerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080/recipe");

    MenuControllerApi apiInstance = new MenuControllerApi(defaultClient);
    Long groupId = 56L; // Long | Csoportazonos�t�
    try {
      List<Menu> result = apiInstance.getMenusByGroupId(groupId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MenuControllerApi#getMenusByGroupId");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **groupId** | **Long**| Csoportazonos�t� | |

### Return type

[**List&lt;Menu&gt;**](Menu.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Sikeres lek�rdez�s |  -  |

<a name="getMostFrequentlyOrderedMenuItem"></a>
# **getMostFrequentlyOrderedMenuItem**
> Menu getMostFrequentlyOrderedMenuItem()

Legt�bbsz�r rendelt �tel lek�rdez�se.

### Example
```java
// Import classes:
import yokudlela.recipe.java.clients.invoker.ApiClient;
import yokudlela.recipe.java.clients.invoker.ApiException;
import yokudlela.recipe.java.clients.invoker.Configuration;
import yokudlela.recipe.java.clients.invoker.models.*;
import yokudlela.recipe.java.clients.api.MenuControllerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080/recipe");

    MenuControllerApi apiInstance = new MenuControllerApi(defaultClient);
    try {
      Menu result = apiInstance.getMostFrequentlyOrderedMenuItem();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MenuControllerApi#getMostFrequentlyOrderedMenuItem");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**Menu**](Menu.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Sikeres lek�rdez�s |  -  |

<a name="getRecipesWithEnoughResources"></a>
# **getRecipesWithEnoughResources**
> List&lt;Recipe&gt; getRecipesWithEnoughResources()

Azon receptek lek�rdez�se, amelyekhez VAN elegend? alapanyag rakt�ron.

### Example
```java
// Import classes:
import yokudlela.recipe.java.clients.invoker.ApiClient;
import yokudlela.recipe.java.clients.invoker.ApiException;
import yokudlela.recipe.java.clients.invoker.Configuration;
import yokudlela.recipe.java.clients.invoker.models.*;
import yokudlela.recipe.java.clients.api.MenuControllerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080/recipe");

    MenuControllerApi apiInstance = new MenuControllerApi(defaultClient);
    try {
      List<Recipe> result = apiInstance.getRecipesWithEnoughResources();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MenuControllerApi#getRecipesWithEnoughResources");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;Recipe&gt;**](Recipe.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Sikeres lek�rdez�s |  -  |

<a name="getRecipesWithNotEnoughResources"></a>
# **getRecipesWithNotEnoughResources**
> List&lt;Recipe&gt; getRecipesWithNotEnoughResources()

Azon receptek lek�rdez�se, amelyekhez NINCS elegend? alapanyag rakt�ron.

### Example
```java
// Import classes:
import yokudlela.recipe.java.clients.invoker.ApiClient;
import yokudlela.recipe.java.clients.invoker.ApiException;
import yokudlela.recipe.java.clients.invoker.Configuration;
import yokudlela.recipe.java.clients.invoker.models.*;
import yokudlela.recipe.java.clients.api.MenuControllerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080/recipe");

    MenuControllerApi apiInstance = new MenuControllerApi(defaultClient);
    try {
      List<Recipe> result = apiInstance.getRecipesWithNotEnoughResources();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MenuControllerApi#getRecipesWithNotEnoughResources");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;Recipe&gt;**](Recipe.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Sikeres lek�rdez�s |  -  |

