package samples.webforms;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;
import com.zoho.crm.api.webforms.APIException;
import com.zoho.crm.api.webforms.AcknowledgeVisitors;
import com.zoho.crm.api.webforms.AssignmentRule;
import com.zoho.crm.api.webforms.ButtonAttributes;
import com.zoho.crm.api.webforms.Fields;
import com.zoho.crm.api.webforms.FontAttributes;
import com.zoho.crm.api.webforms.FormAttributes;
import com.zoho.crm.api.webforms.FromAddress;
import com.zoho.crm.api.webforms.Layout;
import com.zoho.crm.api.webforms.Owner;
import com.zoho.crm.api.webforms.ResponseHandler;
import com.zoho.crm.api.webforms.ResponseWrapper;
import com.zoho.crm.api.webforms.Suggestion;
import com.zoho.crm.api.webforms.Tags;
import com.zoho.crm.api.webforms.User;
import com.zoho.crm.api.webforms.WebForm;
import com.zoho.crm.api.webforms.WebformsOperations;

public class GetWebformsPreview
{
	public static void getWebformsPreview(String moduleAPIName, Long formId) throws Exception
	{
		WebformsOperations webformsOperations = new WebformsOperations(moduleAPIName);
		APIResponse<ResponseHandler> response = webformsOperations.getWebformsPreview(formId);
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
					List<WebForm> webforms = responseWrapper.getWebforms();
					for (WebForm webform : webforms)
					{
						System.out.println("WebForms GoogleSite: " + webform.getGoogleSite());
						System.out.println("WebForms EncryptedFormId: " + webform.getEncryptedFormId());
						AcknowledgeVisitors acknowledgeVisitors = webform.getAcknowledgeVisitor();
						if (acknowledgeVisitors != null)
						{
							System.out.println("WebForms AcknowledgeVisitors TemplateName: " + acknowledgeVisitors.getTemplateName());
							System.out.println("WebForms AcknowledgeVisitors TemplateId: " + acknowledgeVisitors.getTemplateId());
							FromAddress fromAddress = acknowledgeVisitors.getFromAddress();
							if (fromAddress != null)
							{
								System.out.println("WebForms AcknowledgeVisitors FromAddress Type: " + fromAddress.getType());
								System.out.println("WebForms AcknowledgeVisitors FromAddress ID: " + fromAddress.getId());
							}
						}
						List<ButtonAttributes> buttonAttributes = webform.getButtonAttributes();
						if (buttonAttributes != null)
						{
							for (ButtonAttributes buttonAttribute : buttonAttributes)
							{
								System.out.println("WebForms ButtonAttributes Name: " + buttonAttribute.getName());
								System.out.println("WebForms ButtonAttributes Color: " + buttonAttribute.getColor());
							}
						}
						System.out.println("WebForms Type: " + webform.getType());
						System.out.println("WebForms Type: " + webform.getActionOnSubmit());
						List<Fields> formFields = webform.getFormFields();
						if (formFields != null)
						{
							for (Fields formField : formFields)
							{
								Layout layout = formField.getLayout();
								if (layout != null)
								{
									System.out.println("WebForms FormFields Layout Name: " + layout.getName());
									System.out.println("WebForms FormFields Layout ID: " + layout.getId());
								}
								System.out.println("WebForms FormFields Name: " + formField.getHelp());
								Fields fields = formField.getField();
								if (fields != null)
								{
									System.out.println("WebForms FormFields Fields APIName: " + fields.getAPIName());
									System.out.println("WebForms FormFields Fields FieldLabel: " + fields.getFieldLabel());
									System.out.println("WebForms FormFields Fields Id: " + fields.getId());
								}
								System.out.println("WebForms FormFields Hidden: " + formField.getHidden());
								System.out.println("WebForms FormFields Advanced: " + formField.getAdvanced());
								com.zoho.crm.api.webforms.Module module = formField.getModule();
								if (module != null)
								{
									System.out.println("WebForms FormFields Module APIName: " + module.getAPIName());
									System.out.println("WebForms FormFields Module ID: " + module.getId());
								}
								System.out.println("WebForms FormFields DateFormat: " + formField.getDateFormat());
								System.out.println("WebForms FormFields Required: " + formField.getRequired());
								System.out.println("WebForms FormFields FieldName: " + formField.getFieldName());
							}
						}
						System.out.println("WebForms EncryptedZgid: " + webform.getEncryptedZgid());
						System.out.println("WebForms ActionValue: " + webform.getActionValue());
						System.out.println("WebForms Type: " + webform.getType());
						com.zoho.crm.api.webforms.Module module = webform.getModule();
						if (module != null)
						{
							System.out.println("WebForms Module APIName: " + module.getAPIName());
							System.out.println("WebForms Module ID: " + module.getId());
						}
						Suggestion suggestion = webform.getSuggestion();
						if (suggestion != null)
						{
							System.out.println("WebForms Suggestion Type: " + suggestion.getType());
							System.out.println("WebForms Suggestion Available: " + suggestion.getAvailable());
						}
						System.out.println("WebForms EncryptedModule: " + webform.getEncryptedModule());
						System.out.println("WebForms Active: " + webform.getActive());
						System.out.println("WebForms AdwordEnabled: " + webform.getAdwordEnabled());
						Owner notifyOwner = webform.getNotifyOwner();
						if (notifyOwner != null)
						{
							System.out.println("WebForms NotifyOwner Name: " + notifyOwner.getName());
							System.out.println("WebForms NotifyOwner Id: " + notifyOwner.getId());
						}
						User createdBy = webform.getCreatedBy();
						if (createdBy != null)
						{
							System.out.println("WebForms CreatedBy Name: " + createdBy.getName());
							System.out.println("WebForms CreatedBy Id: " + createdBy.getId());
						}
						FormAttributes formAttributes = webform.getFormAttributes();
						if (formAttributes != null)
						{
							System.out.println("WebForms FormAttributes Color: " + formAttributes.getColor());
							System.out.println("WebForms FormAttributes Width: " + formAttributes.getWidth());
							FontAttributes fontAttributes = formAttributes.getFontAttributes();
							if (fontAttributes != null)
							{
								System.out.println("WebForms FormAttributes FontAttributes Size: " + fontAttributes.getSize());
								System.out.println("WebForms FormAttributes FontAttributes Color: " + fontAttributes.getColor());
								System.out.println("WebForms FormAttributes FontAttributes Family: " + fontAttributes.getFamily());
							}
							System.out.println("WebForms FormAttributes DisplayFormName: " + formAttributes.getDisplayFormName());
							System.out.println("WebForms FormAttributes Align: " + formAttributes.getAlign());
						}
						List<String> locationUrl = webform.getLocationUrl();
						if (locationUrl != null)
						{
							for (String url : locationUrl)
							{
								System.out.println("WebForms LocationUrl: " + url);
							}
						}
						System.out.println("WebForms DoubleOptinEnabled: " + webform.getDoubleOptinEnabled());
						List<Tags> tags = webform.getTags();
						if (tags != null)
						{
							for (Tags tag : tags)
							{
								System.out.println("WebForms Tags Name: " + tag.getName());
								System.out.println("WebForms Tags ID: " + tag.getId());
							}
						}
						Layout layout = webform.getLayout();
						if (layout != null)
						{
							System.out.println("WebForms Layout Name: " + layout.getName());
							System.out.println("WebForms Layout Id: " + layout.getId());
						}
						System.out.println("WebForms ApprovalRequest: " + webform.getApprovalRequest());
						System.out.println("WebForms CreateContact: " + webform.getCreateContact());
						AssignmentRule assignmentRule = webform.getAssignmentRule();
						if (assignmentRule != null)
						{
							System.out.println("WebForms AssignmentRule Name: " + assignmentRule.getName());
							System.out.println("WebForms AssignmentRule Id: " + assignmentRule.getId());
						}
						System.out.println("WebForms Name: " + webform.getName());
						System.out.println("WebForms Id: " + webform.getId());
						System.out.println("WebForms VisitorTracking: " + webform.getVisitorTracking());
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
			String moduleAPIName = "Leads";
			Long formId = 347701l;
			getWebformsPreview(moduleAPIName, formId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
