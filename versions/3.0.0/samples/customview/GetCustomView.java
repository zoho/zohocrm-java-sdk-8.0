package samples.customview;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.customviews.APIException;
import com.zoho.crm.api.customviews.ResponseWrapper;
import com.zoho.crm.api.customviews.Criteria;
import com.zoho.crm.api.customviews.CustomViewsOperations;
import com.zoho.crm.api.customviews.CustomViewsOperations.GetCustomViewsParam;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.customviews.Fields;
import com.zoho.crm.api.customviews.Info;
import com.zoho.crm.api.customviews.Owner;
import com.zoho.crm.api.customviews.ResponseHandler;
import com.zoho.crm.api.customviews.SharedTo;
import com.zoho.crm.api.customviews.Translation;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetCustomView
{
	public static void getCustomView(String moduleAPIName, Long customViewId) throws Exception
	{
		CustomViewsOperations customViewsOperations = new CustomViewsOperations();
		ParameterMap paramInstance = new ParameterMap();
		paramInstance.add(GetCustomViewsParam.MODULE, moduleAPIName);
		APIResponse<ResponseHandler> response = customViewsOperations.getCustomView(customViewId, paramInstance);
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
					List<com.zoho.crm.api.customviews.CustomViews> customViews = responseWrapper.getCustomViews();
					for (com.zoho.crm.api.customviews.CustomViews customView : customViews)
					{
						System.out.println("CustomView DisplayValue: " + customView.getDisplayValue());
						System.out.println("CustomView AccessType: " + customView.getAccessType());
						System.out.println("CustomView SystemName: " + customView.getSystemName());
						Criteria criteria = customView.getCriteria();
						if (criteria != null)
						{
							printCriteria(criteria);
						}
						List<SharedTo> sharedToDetails = customView.getSharedTo();
						if (sharedToDetails != null)
						{
							for (SharedTo sharedTo : sharedToDetails)
							{
								System.out.println("SharedDetails Name: " + sharedTo.getName());
								System.out.println("SharedDetails ID: " + sharedTo.getId());
								System.out.println("SharedDetails Type: " + sharedTo.getType());
								System.out.println("SharedDetails Subordinates: " + sharedTo.getSubordinates().toString());
							}
						}
						System.out.println("CustomView SortBy: " + customView.getSortBy());
						System.out.println("CustomView Default: " + customView.getDefault().toString());
						System.out.println("CustomView SystemDefined: " + customView.getSystemDefined().toString());
						System.out.println("CustomView Name: " + customView.getName());
						System.out.println("CustomView ID: " + customView.getId());
						System.out.println("CustomView Category: " + customView.getCategory());
						if (customView.getFavorite() != null)
						{
							System.out.println("CustomView Favorite: " + customView.getFavorite().toString());
						}
						if (customView.getSortOrder() != null)
						{
							System.out.println("CustomView SortOrder: " + customView.getSortOrder().toString());
						}
						List<Fields> fields = customView.getFields();
						if (fields != null)
						{
							for (Fields field : fields)
							{
								System.out.println("Custome view field name: " + field.getAPIName());
							}
						}
						System.out.println("CustomView LastAccessedType: " + customView.getLastAccessedTime());
						System.out.println("CustomView ModifiedTime: " + customView.getModifiedTime());
						Owner createdBy = customView.getCreatedBy();
						if (createdBy != null)
						{
							System.out.println("CustomView Created By Name : " + createdBy.getName());
							System.out.println("CustomView Created By id : " + createdBy.getId());
							System.out.println("CustomView Created By Name : " + createdBy.getEmail());
						}
						Owner modifiedBy = customView.getModifiedBy();
						if (modifiedBy != null)
						{
							System.out.println("CustomView Modified By Name : " + modifiedBy.getName());
							System.out.println("CustomView Modified By id : " + modifiedBy.getId());
							System.out.println("CustomView Modified By Name : " + modifiedBy.getEmail());
						}
					}
					Info info = responseWrapper.getInfo();
					if (info != null)
					{
						Translation translation = info.getTranslation();
						if (translation != null)
						{
							System.out.println("CustomView Info Translation PublicViews: " + translation.getPublicViews());
							System.out.println("CustomView Info Translation OtherUsersViews: " + translation.getOtherUsersViews());
							System.out.println("CustomView Info Translation SharedWithMe: " + translation.getSharedWithMe());
							System.out.println("CustomView Info Translation CreatedByMe: " + translation.getCreatedByMe());
						}
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

	private static void printCriteria(Criteria criteria)
	{
		if (criteria.getComparator() != null)
		{
			System.out.println("CustomView Criteria Comparator: " + criteria.getComparator());
		}
		if (criteria.getField() != null)
		{
			System.out.println("CustomView Criteria field name: " + criteria.getField().getAPIName());
		}
		if (criteria.getValue() != null)
		{
			System.out.println("CustomView Criteria Value: " + criteria.getValue().toString());
		}
		List<Criteria> criteriaGroup = criteria.getGroup();
		if (criteriaGroup != null)
		{
			for (Criteria criteria1 : criteriaGroup)
			{
				printCriteria(criteria1);
			}
		}
		if (criteria.getGroupOperator() != null)
		{
			System.out.println("CustomView Criteria Group Operator: " + criteria.getGroupOperator());
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
			Long customViewId = 3477501l;
			getCustomView(moduleAPIName, customViewId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
