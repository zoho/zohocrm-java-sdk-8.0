package samples.mailmerge;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.files.FileBodyWrapper;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.mailmerge.APIException;
import com.zoho.crm.api.mailmerge.DownloadResponseHandler;
import com.zoho.crm.api.mailmerge.DownloadMailMergeWrapper;
import com.zoho.crm.api.mailmerge.MailMergeOperations;
import com.zoho.crm.api.mailmerge.MailMergeTemplate;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;
import com.zoho.crm.api.util.StreamWrapper;

public class DownloadMailMerge
{
	public static void downloadMailMerge(String module, String id, String destinationFolder) throws Exception
	{
		MailMergeOperations mailMergeOperations = new MailMergeOperations(module, id);
		DownloadMailMergeWrapper request = new DownloadMailMergeWrapper();
		List<com.zoho.crm.api.mailmerge.DownloadMailMerge> downloadMailMerge = new ArrayList<>();
		com.zoho.crm.api.mailmerge.DownloadMailMerge mailmerge = new com.zoho.crm.api.mailmerge.DownloadMailMerge();
		MailMergeTemplate mailMergeTemplate = new MailMergeTemplate();
		mailMergeTemplate.setName("Test");
		mailmerge.setMailMergeTemplate(mailMergeTemplate);
		mailmerge.setOutputFormat(new Choice<String>("pdf"));
		mailmerge.setFileName("SDK Name");
		mailmerge.setPassword("TestSDK");
		downloadMailMerge.add(mailmerge);
		request.setDownloadMailMerge(downloadMailMerge);
		APIResponse<DownloadResponseHandler> response = mailMergeOperations.downloadMailMerge(request);
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.isExpected())
			{
				DownloadResponseHandler responseHandler = response.getObject();
				if (responseHandler instanceof FileBodyWrapper)
				{
					FileBodyWrapper fileBodyWrapper = (FileBodyWrapper) responseHandler;
					StreamWrapper streamWrapper = fileBodyWrapper.getFile();
					java.io.File file = new java.io.File(destinationFolder + java.io.File.separatorChar + streamWrapper.getName());
					InputStream is = streamWrapper.getStream();
					OutputStream os = new FileOutputStream(file);
					byte[] buffer = new byte[1024];
					int bytesRead;
					while ((bytesRead = is.read(buffer)) != -1)
					{
						os.write(buffer, 0, bytesRead);
					}
					is.close();
					os.flush();
					os.close();
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
			String Id = "34770827001";
			String module = "Leads";
			String destinationFolder = "/Users/file";
			downloadMailMerge(module, Id, destinationFolder);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
