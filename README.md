# ZOHO CRM JAVA SDK 8.0 for API version 8

The Java SDK for Zoho CRM allows developers to easily create Java applications that can be integrated with Zoho CRM. This SDK serves as a wrapper for the REST APIs, making it easier to access and utilize the services of Zoho CRM. 
Authentication to access the CRM APIs is done through OAuth2.0, and the authentication process is streamlined through the use of the Java SDK. The grant and access/refresh tokens are generated and managed within the SDK code, eliminating the need for manual handling during data synchronization between Zoho CRM and the client application.

This repository includes the JAVA SDK for API v8 of Zoho CRM. Check [Versions](https://github.com/zoho/zohocrm-java-sdk-8.0/releases) for more details on the versions of SDK released for this API version.

License
=======

    Copyright (c) 2021, ZOHO CORPORATION PRIVATE LIMITED 
    All rights reserved. 

    Licensed under the Apache License, Version 2.0 (the "License"); 
    you may not use this file except in compliance with the License. 
    You may obtain a copy of the License at 
    
        http://www.apache.org/licenses/LICENSE-2.0 
    
    Unless required by applicable law or agreed to in writing, software 
    distributed under the License is distributed on an "AS IS" BASIS, 
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
    See the License for the specific language governing permissions and 
    limitations under the License.

## Latest Version

- [2.0.0](/versions/2.0.0/README.md)
    - New fields have been added to the History Tracking Fields API. 
    - Fixed the issue with the inventory mass conversion status API.

- [1.0.0](/versions/1.0.0/README.md)

    - Java SDK upgraded to support v8 APIs.

    - Java SDK improved to support the following new APIs

      - [Get Related Records Count of a Record](https://www.zoho.com/crm/developer/docs/api/v8/get-related-records-count.html)
      - [Calls Preference](https://www.zoho.com/crm/developer/docs/api/v8/get-calls-preferences.html)
      - [Record-Level Sharing of Emails](https://www.zoho.com/crm/developer/docs/api/v8/share-emails.html)
      - [Data Sharing Rules API](https://www.zoho.com/crm/developer/docs/api/v8/data-sharing-rules.html)
      - [Get Rich Text Fields API](https://www.zoho.com/crm/developer/docs/api/v8/get-rich-text-fields.html)


For older versions, please [refer](https://github.com/zoho/zohocrm-java-sdk-8.0/releases).


## Including the SDK in your project
You can include the SDK to your project using:
- Maven
- [Gradle](/versions/2.0.0/README.md#including-the-sdk-in-your-project)
- [Download SDK jar](https://maven.zohodl.com/com/zoho/crm/zohocrm-java-sdk-8-0/2.0.0/zohocrm-java-sdk-8-0-2.0.0.jar)

For including the latest [version](https://github.com/zoho/zohocrm-java-sdk-8.0/releases/tag/2.0.0) using Maven, include the following in your **pom.xml** file, which will get created once your **Java** project is created using Maven.

    ```xml
    <repositories>
        <repository>
            <id>zohocrm-java-sdk-8-0</id>
            <url>https://maven.zohodl.com</url>
        </repository>
    </repositories>
    <dependencies>
        <dependency>
            <groupId>com.zoho.crm</groupId>
            <artifactId>zohocrm-java-sdk-8-0</artifactId>
            <version>2.0.0</version>
        </dependency>
    </dependencies>
    ```

---

**NOTE** 

> - The **access and refresh tokens are environment-specific and domain-specific**. When you handle various environments and domains such as **Production**, **Sandbox**, or **Developer** and **IN**, **CN**, **US**, **EU**, **JP**, or **AU**, respectively, you must use the access token and refresh token generated only in those respective environments and domains. The SDK throws an error, otherwise.
For example, if you generate the tokens for your Sandbox environment in the CN domain, you must use only those tokens for that domain and environment. You cannot use the tokens generated for a different environment or a domain.

> - For **Deals - Contact Roles API and Records API**, you will need to provide the **ZohoCRM.settings.fields.ALL** scope along with the **ZohoCRM.modules.ALL** scope while generating the OAuthtoken. Otherwise, the system returns the **OAUTH-SCOPE-MISMATCH** error.

> - For **Related Records API**, the scopes required for generating OAuthtoken are **ZohoCRM.modules.ALL**, **ZohoCRM.settings.fields.ALL** and **ZohoCRM.settings.related_lists.ALL**. Otherwise, the system returns the **OAUTH-SCOPE-MISMATCH** error.

> - For **Mass Convert API**, you will need to provide the **ZohoCRM.settings.fields.ALL** scope along with the **ZohoCRM.mass_convert.leads.CREATE** and **ZohoCRM.mass_convert.leads.READ** scope while generating the OAuthtoken. Otherwise, the system returns the **OAUTH-SCOPE-MISMATCH** error.

---

For more details, kindly refer [here](/versions/2.0.0/README.md).
