package samples.webforms;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;
import com.zoho.crm.api.webforms.ActionHandler;
import com.zoho.crm.api.webforms.ActionResponse;
import com.zoho.crm.api.webforms.ActionWrapper;
import com.zoho.crm.api.webforms.AnalyticsData;
import com.zoho.crm.api.webforms.BodyWrapper;
import com.zoho.crm.api.webforms.ButtonAttributes;
import com.zoho.crm.api.webforms.Fields;
import com.zoho.crm.api.webforms.FontAttributes;
import com.zoho.crm.api.webforms.FormAttributes;
import com.zoho.crm.api.webforms.Layout;
import com.zoho.crm.api.webforms.Owner;
import com.zoho.crm.api.webforms.SuccessResponse;
import com.zoho.crm.api.webforms.Tags;
import com.zoho.crm.api.webforms.User;
import com.zoho.crm.api.webforms.WebForm;
import com.zoho.crm.api.webforms.WebformsOperations;
import com.zoho.crm.api.webforms.APIException;
import com.zoho.crm.api.webforms.AcknowledgeVisitors;

public class UpdateWebForm
{
	public static void updateWebForm(String moduleAPIName, Long formId) throws Exception
	{
		WebformsOperations webformsOperations = new WebformsOperations(moduleAPIName);
		BodyWrapper request = new BodyWrapper();
		List<WebForm> webforms = new ArrayList<>();
		WebForm webform = new WebForm();
		webform.setName("sample");
		com.zoho.crm.api.webforms.Module module = new com.zoho.crm.api.webforms.Module();
		module.setId(34772175l);
		module.setModuleName(moduleAPIName);
		module.setAPIName(moduleAPIName);
		webform.setModule(module);
		Layout layout = new Layout();
		layout.setId(3477099001l);
		webform.setLayout(layout);
		FormAttributes formAttributes = new FormAttributes();
		formAttributes.setColor("White");
		formAttributes.setWidth(600);
		formAttributes.setAlign("left");
		FontAttributes fontAttributes = new FontAttributes();
		fontAttributes.setSize(12);
		fontAttributes.setColor("black");
		fontAttributes.setFamily("Arial");
		formAttributes.setFontAttributes(fontAttributes);
		formAttributes.setDisplayFormName("true");
		webform.setFormAttributes(formAttributes);
		List<ButtonAttributes> buttonAttributes = new ArrayList<>();
		ButtonAttributes buttonAttribute = new ButtonAttributes();
		buttonAttribute.setColor("#fff");
		buttonAttribute.setName("Submit");
		buttonAttributes.add(buttonAttribute);
		buttonAttribute = new ButtonAttributes();
		buttonAttribute.setColor("#fff");
		buttonAttribute.setName("Reset");
		buttonAttributes.add(buttonAttribute);
		webform.setButtonAttributes(buttonAttributes);
		Owner owner = new Owner();
		owner.setId(3477091024l);
		webform.setOwner(owner);
		webform.setCreateContact(false);
		List<Tags> tags = new ArrayList<>();
		Tags tag = new Tags();
		tag.setId(347706002l);
		tag.setName("Chems");
		tags.add(tag);
		webform.setTags(tags);
		webform.setDoubleOptinEnabled(false);
		Owner notifyOwner = new Owner();
		notifyOwner.setId(347706124l);
		webform.setNotifyOwner(notifyOwner);
		AcknowledgeVisitors  acknowledgeVisitors = new AcknowledgeVisitors();
		webform.setAcknowledgeVisitor(acknowledgeVisitors);
		webform.setVisitorTracking("");
		webform.setApprovalRequest(false);
		webform.setType("webform");
		User userType = new User();
		userType.setId(null);
		webform.setUserType(userType);
		webform.setActionOnSubmit("splash_message");
		webform.setActionValue("Splash Message");
		List<String> locationUrl = new ArrayList<String>();
		locationUrl.add("*");
		webform.setLocationUrl(locationUrl);
		AnalyticsData analyticsData = new AnalyticsData();
		analyticsData.setAnalyticsEnabled(true);
		webform.setAnalyticsData(analyticsData);
		List<Fields> formFields = new ArrayList<Fields>();
		Fields formField = new Fields();
		Layout fieldLayout = new Layout();
		fieldLayout.setName("SDK");
		fieldLayout.setId(347706001l);
		formField.setLayout(fieldLayout);
		formField.setHelp("");
		Fields formField1 = new Fields();
		formField1.setAPIName("Company");
		formField1.setFieldLabel("Company");
		formField1.setId(347706102591l);
		formField.setField(formField1);
		formField.setHidden(false);
		formField.setAdvanced(false);
		com.zoho.crm.api.webforms.Module fieldModue = new com.zoho.crm.api.webforms.Module();
		fieldModue.setAPIName(moduleAPIName);
		fieldModue.setId(347706102175l);
		formField.setModule(fieldModue);
		formField.setDateFormat("");
		formField.setRequired(true);
		formField.setFieldName("Company");
		formFields.add(formField);
		webform.setFormFields(formFields);
		webforms.add(webform);
		request.setWebforms(webforms);
		APIResponse<ActionHandler> response = webformsOperations.updateWebForm(formId, request);
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.isExpected())
			{
				ActionHandler actionHandler = response.getObject();
				if (actionHandler instanceof ActionWrapper)
				{
					ActionWrapper actionWrapper = (ActionWrapper) actionHandler;
					List<ActionResponse> actionResponses = actionWrapper.getWebforms();
					for (ActionResponse actionResponse : actionResponses)
					{
						if (actionResponse instanceof SuccessResponse)
						{
							SuccessResponse successResponse = (SuccessResponse) actionResponse;
							System.out.println("Status: " + successResponse.getStatus().getValue());
							System.out.println("Code: " + successResponse.getCode().getValue());
							System.out.println("Details: ");
							for (Map.Entry<String, Object> entry : successResponse.getDetails().entrySet())
							{
								System.out.println(entry.getKey() + ": " + entry.getValue());
							}
							System.out.println("Message: " + successResponse.getMessage());
						}
						else if (actionResponse instanceof APIException)
						{
							APIException exception = (APIException) actionResponse;
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
				}
				else if (actionHandler instanceof APIException)
				{
					APIException exception = (APIException) actionHandler;
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
			String moduleAPIName = "Leads";
			Long formId = 3477958001l;
			updateWebForm(moduleAPIName, formId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
