package samples.users;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.HeaderMap;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.users.APIException;
import com.zoho.crm.api.users.CustomizeInfo;
import com.zoho.crm.api.users.Profile;
import com.zoho.crm.api.users.ResponseHandler;
import com.zoho.crm.api.users.ResponseWrapper;
import com.zoho.crm.api.users.Role;
import com.zoho.crm.api.users.Tab;
import com.zoho.crm.api.users.Theme;
import com.zoho.crm.api.users.UsersOperations;
import com.zoho.crm.api.users.UsersOperations.GetUsersHeader;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetUser
{
	public static void getUser(Long userId) throws Exception
	{
		UsersOperations usersOperations = new UsersOperations();
		HeaderMap headerInstance = new HeaderMap();
		OffsetDateTime ifmodifiedsince = OffsetDateTime.of(2019, 01, 02, 10, 00, 01, 00, ZoneOffset.of("+05:30"));
		headerInstance.add(GetUsersHeader.IF_MODIFIED_SINCE, ifmodifiedsince);
		APIResponse<ResponseHandler> response = usersOperations.getUser(userId, headerInstance);
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (Arrays.asList(204, 304).contains(response.getStatusCode()))
			{
				System.out.println(response.getStatusCode() == 204 ? "No Content" : "Not Modified");
				return;
			}
			if (response.isExpected())
			{
				ResponseHandler responseHandler = response.getObject();
				if (responseHandler instanceof ResponseWrapper)
				{
					ResponseWrapper responseWrapper = (ResponseWrapper) responseHandler;
					List<com.zoho.crm.api.users.Users> users = responseWrapper.getUsers();
					for (com.zoho.crm.api.users.Users user : users)
					{
						System.out.println("User Country: " + user.getCountry());
						CustomizeInfo customizeInfo = user.getCustomizeInfo();
						if (customizeInfo != null)
						{
							if (customizeInfo.getNotesDesc() != null)
							{
								System.out.println("User CustomizeInfo NotesDesc: " + customizeInfo.getNotesDesc().toString());
							}
							if (customizeInfo.getShowRightPanel() != null)
							{
								System.out.println("User CustomizeInfo ShowRightPanel: " + customizeInfo.getShowRightPanel().toString());
							}
							if (customizeInfo.getBcView() != null)
							{
								System.out.println("User CustomizeInfo BcView: " + customizeInfo.getBcView().toString());
							}
							if (customizeInfo.getShowHome() != null)
							{
								System.out.println("User CustomizeInfo ShowHome: " + customizeInfo.getShowHome().toString());
							}
							if (customizeInfo.getShowDetailView() != null)
							{
								System.out.println("User CustomizeInfo ShowDetailView: " + customizeInfo.getShowDetailView().toString());
							}
							if (customizeInfo.getUnpinRecentItem() != null)
							{
								System.out.println("User CustomizeInfo UnpinRecentItem: " + customizeInfo.getUnpinRecentItem().toString());
							}
						}
						Role role = user.getRole();
						if (role != null)
						{
							System.out.println("User Role Name: " + role.getName());
							System.out.println("User Role ID: " + role.getId());
						}
						System.out.println("User Signature: " + user.getSignature());
						System.out.println("User SortOrderPreference: " + user.getSortOrderPreference());
						System.out.println("User City: " + user.getCity());
						System.out.println("User Isonline: " + user.getIsonline());
						System.out.println("User SandboxDeveloper: " + user.getSandboxdeveloper().toString());
						System.out.println("User Zip: " + user.getZip());
						System.out.println("User NameFormat: " + user.getNameFormatS());
						System.out.println("User Language: " + user.getLanguage());
						System.out.println("User Locale: " + user.getLocale());
						System.out.println("User Microsoft: " + user.getMicrosoft().toString());
						if (user.getPersonalAccount() != null)
						{
							System.out.println("User PersonalAccount: " + user.getPersonalAccount().toString());
						}
						System.out.println("User DefaultTabGroup: " + user.getDefaultTabGroup());
						System.out.println("User Isonline: " + user.getIsonline().toString());
						com.zoho.crm.api.users.MinifiedUser modifiedBy = user.getModifiedBy();
						if (modifiedBy != null)
						{
							System.out.println("User Modified By User-Name: " + modifiedBy.getName());
							System.out.println("User Modified By User-ID: " + modifiedBy.getId());
						}
						System.out.println("User Street: " + user.getStreet());
						System.out.println("User Currency: " + user.getCurrency());
						System.out.println("User Alias: " + user.getAlias());
						Theme theme = user.getTheme();
						if (theme != null)
						{
							Tab normalTab = theme.getNormalTab();
							if (normalTab != null)
							{
								System.out.println("User Theme NormalTab FontColor: " + normalTab.getFontColor());
								System.out.println("User Theme NormalTab Name: " + normalTab.getBackground());
							}
							Tab selectedTab = theme.getSelectedTab();
							if (selectedTab != null)
							{
								System.out.println("User Theme SelectedTab FontColor: " + selectedTab.getFontColor());
								System.out.println("User Theme SelectedTab Name: " + selectedTab.getBackground());
							}
							System.out.println("User Theme NewBackground: " + theme.getNewBackground());
							System.out.println("User Theme Background: " + theme.getBackground());
							System.out.println("User Theme Screen: " + theme.getScreen());
							System.out.println("User Theme Type: " + theme.getType());
						}
						System.out.println("User ID: " + user.getId());
						System.out.println("User State: " + user.getState());
						System.out.println("User Fax: " + user.getFax());
						System.out.println("User CountryLocale: " + user.getCountryLocale());
						System.out.println("User FirstName: " + user.getFirstName());
						System.out.println("User Email: " + user.getEmail());
						com.zoho.crm.api.users.MinifiedUser reportingTo = user.getReportingTo();
						if (reportingTo != null)
						{
							System.out.println("User ReportingTo Name: " + reportingTo.getName());
							System.out.println("User ReportingTo ID: " + reportingTo.getId());
						}
						System.out.println("User DecimalSeparator: " + user.getDecimalSeparator());
						System.out.println("User Zip: " + user.getZip());
						System.out.println("User CreatedTime: " + user.getCreatedTime());
						System.out.println("User Website: " + user.getWebsite());
						System.out.println("User ModifiedTime: " + user.getModifiedTime());
						System.out.println("User TimeFormat: " + user.getTimeFormat());
						System.out.println("User Offset: " + user.getOffset().toString());
						Profile profile = user.getProfile();
						if (profile != null)
						{
							System.out.println("User Profile Name: " + profile.getName());
							System.out.println("User Profile ID: " + profile.getId());
						}
						System.out.println("User Mobile: " + user.getMobile());
						System.out.println("User LastName: " + user.getLastName());
						System.out.println("User TimeZone: " + user.getTimeZone());
						com.zoho.crm.api.users.MinifiedUser createdBy = user.getCreatedBy();
						if (createdBy != null)
						{
							System.out.println("User Created By User-Name: " + createdBy.getName());
							System.out.println("User Created By User-ID: " + createdBy.getId());
						}
						System.out.println("User Zuid: " + user.getZuid());
						System.out.println("User Confirm: " + user.getConfirm().toString());
						System.out.println("User FullName: " + user.getFullName());
						System.out.println("User Phone: " + user.getPhone());
						System.out.println("User DOB: " + user.getDob());
						System.out.println("User DateFormat: " + user.getDateFormat());
						System.out.println("User Status: " + user.getStatus());
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
				java.lang.reflect.Field[] fields = clas.getDeclaredFields();
				for (java.lang.reflect.Field field : fields)
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
			Long userId = 440248254001L;
			getUser(userId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
