package samples.organization;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.org.APIException;
import com.zoho.crm.api.org.HierarchyPreferences;
import com.zoho.crm.api.org.LicenseDetails;
import com.zoho.crm.api.org.OrgOperations;
import com.zoho.crm.api.org.ResponseHandler;
import com.zoho.crm.api.org.ResponseWrapper;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetOrganization
{
	public static void getOrganization() throws Exception
	{
		OrgOperations orgOperations = new OrgOperations();
		APIResponse<ResponseHandler> response = orgOperations.getOrganization();
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.isExpected())
			{
				ResponseHandler responseHandler = response.getObject();
				if (responseHandler instanceof ResponseWrapper)
				{
					ResponseWrapper responseWrapper = (ResponseWrapper) responseHandler;
					List<com.zoho.crm.api.org.Org> orgs = responseWrapper.getOrg();
					for (com.zoho.crm.api.org.Org org : orgs)
					{
						System.out.println("Organization Country: " + org.getCountry());
						HierarchyPreferences hierarchyPreferences = org.getHierarchyPreferences();
						if (hierarchyPreferences != null)
						{
							System.out.println("Organization HierarchyPreferences Type: " + hierarchyPreferences.getType());
						}
						System.out.println("Organization PhotoId: " + org.getPhotoId());
						System.out.println("Organization City: " + org.getCity());
						System.out.println("Organization Description: " + org.getDescription());
						System.out.println("Organization McStatus: " + org.getMcStatus().toString());
						System.out.println("Organization GappsEnabled: " + org.getGappsEnabled().toString());
						System.out.println("Organization DomainName: " + org.getDomainName());
						System.out.println("Organization TranslationEnabled: " + org.getTranslationEnabled().toString());
						System.out.println("Organization Street: " + org.getStreet());
						System.out.println("Organization Alias: " + org.getAlias());
						System.out.println("Organization Currency: " + org.getCurrency());
						System.out.println("Organization Id: " + org.getId());
						System.out.println("Organization State: " + org.getState());
						System.out.println("Organization Fax: " + org.getFax());
						System.out.println("Organization EmployeeCount: " + org.getEmployeeCount());
						System.out.println("Organization Zip: " + org.getZip());
						System.out.println("Organization Website: " + org.getWebsite());
						System.out.println("Organization CurrencySymbol: " + org.getCurrencySymbol());
						System.out.println("Organization Mobile: " + org.getMobile());
						System.out.println("Organization CurrencyLocale: " + org.getCurrencyLocale());
						System.out.println("Organization PrimaryZuid: " + org.getPrimaryZuid());
						System.out.println("Organization ZiaPortalId: " + org.getZiaPortalId());
						System.out.println("Organization TimeZone: " + org.getTimeZone());
						System.out.println("Organization Zgid: " + org.getZgid());
						System.out.println("Organization CountryCode: " + org.getCountryCode());
						LicenseDetails licenseDetails = org.getLicenseDetails();
						if (licenseDetails != null)
						{
							System.out.println("Organization LicenseDetails PaidExpiry: " + licenseDetails.getPaidExpiry());
							System.out.println("Organization LicenseDetails UsersLicensePurchased: " + licenseDetails.getUsersLicensePurchased().toString());
							System.out.println("Organization LicenseDetails TrialType: " + licenseDetails.getTrialType());
							System.out.println("Organization LicenseDetails TrialExpiry: " + licenseDetails.getTrialExpiry());
							System.out.println("Organization LicenseDetails Paid: " + licenseDetails.getPaid().toString());
							System.out.println("Organization LicenseDetails PaidType: " + licenseDetails.getPaidType());
						}
						System.out.println("Organization Phone: " + org.getPhone());
						System.out.println("Organization CompanyName: " + org.getCompanyName());
						System.out.println("Organization PrivacySettings: " + org.getPrivacySettings().toString());
						System.out.println("Organization HipaaComplianceEnabled: " + org.getHipaaComplianceEnabled());
						System.out.println("Organization PrimaryEmail: " + org.getPrimaryEmail());
						System.out.println("Organization IsoCode: " + org.getIsoCode());
					}
				}
				else if (responseHandler instanceof APIException)
				{
					APIException exception = (APIException) responseHandler;
					System.out.println("Status: " + exception.getStatus().getValue());
					System.out.println("Code: " + exception.getCode().getValue());
					System.out.println("Details: ");
					for (Map.Entry<String, Object> entry : exception.getDetails().entrySet())
					{
						System.out.println(entry.getKey() + ": " + entry.getValue());
					}
					System.out.println("Message: " + exception.getMessage());
				}
			}
			else
			{
				Model responseObject = response.getModel();
				Class<? extends Model> clas = responseObject.getClass();
				Field[] fields = clas.getDeclaredFields();
				for (Field field : fields)
				{
					field.setAccessible(true);
					System.out.println(field.getName() + ":" + field.get(responseObject));
				}
			}
		}
	}

	public static void main(String[] args)
	{
		try
		{
			Environment environment = USDataCenter.PRODUCTION;
			Token token = new OAuthToken.Builder().clientID("Client_Id").clientSecret("Client_Secret").refreshToken("Refresh_Token").redirectURL("Redirect_URL").build();
			new Initializer.Builder().environment(environment).token(token).initialize();
			getOrganization();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
