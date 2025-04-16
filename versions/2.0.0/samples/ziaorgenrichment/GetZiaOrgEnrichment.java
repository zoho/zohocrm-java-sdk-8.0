package samples.ziaorgenrichment;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.ziaorgenrichment.APIException;
import com.zoho.crm.api.ziaorgenrichment.Address;
import com.zoho.crm.api.ziaorgenrichment.Description;
import com.zoho.crm.api.ziaorgenrichment.EnrichBasedOn;
import com.zoho.crm.api.ziaorgenrichment.EnrichedData;
import com.zoho.crm.api.ziaorgenrichment.Industry;
import com.zoho.crm.api.ziaorgenrichment.ZiaOrgEnrichmentOperations;
import com.zoho.crm.api.ziaorgenrichment.ResponseHandler;
import com.zoho.crm.api.ziaorgenrichment.ResponseWrapper;
import com.zoho.crm.api.ziaorgenrichment.SocialMedia;
import com.zoho.crm.api.ziaorgenrichment.ZiaOrgEnrichment;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetZiaOrgEnrichment
{
	public static void getZiaOrgEnrichment(Long ziaOrgEnrichmentId) throws Exception
	{
		ZiaOrgEnrichmentOperations ziaOrgEnrichmentOperations = new ZiaOrgEnrichmentOperations();
		APIResponse<ResponseHandler> response = ziaOrgEnrichmentOperations.getZiaOrgEnrichment(ziaOrgEnrichmentId);
		if (response != null)
		{
			System.out.println("Status Code: " + response.getStatusCode());
			if (response.getStatusCode() == 204)
			{
				System.out.println("No Content");
				return;
			}
			if (response.isExpected())
			{
				ResponseHandler responseHandler = response.getObject();
				if (responseHandler instanceof ResponseWrapper)
				{
					ResponseWrapper responseWrapper = (ResponseWrapper) responseHandler;
					List<ZiaOrgEnrichment> ziaorgenrichment = responseWrapper.getZiaOrgEnrichment();
					if(ziaorgenrichment != null)
					{
						for(ZiaOrgEnrichment ziaorgenrichment1 : ziaorgenrichment)
						{
							EnrichedData enrichedData = ziaorgenrichment1.getEnrichedData();
							if(enrichedData != null)
							{
								System.out.println("ZiaOrgEnrichment EnrichedData OrgStatus : " + enrichedData.getOrgStatus());
								List<Description> description = enrichedData.getDescription();
								if(description != null)
								{
									for(Description description1 : description)
									{
										System.out.println("ZiaOrgEnrichment EnrichedData Title : " + description1.getTitle());
										System.out.println("ZiaOrgEnrichment EnrichedData Description : " + description1.getDescription());	
									}
								}
								System.out.println("ZiaOrgEnrichment EnrichedData Description : " + enrichedData.getDescription());
								System.out.println("ZiaOrgEnrichment EnrichedData CEO : " + enrichedData.getCeo());
								System.out.println("ZiaOrgEnrichment EnrichedData SecondaryEmail : " + enrichedData.getSecondaryEmail());
								System.out.println("ZiaOrgEnrichment EnrichedData Revenue : " + enrichedData.getRevenue());
								System.out.println("ZiaOrgEnrichment EnrichedData YearsInIndustry : " + enrichedData.getYearsInIndustry());
								List<String> otherContacts = enrichedData.getOtherContacts();
								if(otherContacts != null)
								{
									for(String otherContact : otherContacts)
									{
										System.out.println("ZiaOrgEnrichment EnrichedData OtherContacts : " + otherContact);
									}
								}
								System.out.println("ZiaOrgEnrichment EnrichedData TechnoGraphicData : " + enrichedData.getTechnoGraphicData());
								System.out.println("ZiaOrgEnrichment EnrichedData Logo : " + enrichedData.getLogo());
								System.out.println("ZiaOrgEnrichment EnrichedData SecondaryContact : " + enrichedData.getSecondaryContact());
								System.out.println("ZiaOrgEnrichment EnrichedData Id: " + enrichedData.getId());
								List<String> otherEmails = enrichedData.getOtherEmails();
								if(otherEmails != null)
								{
									for(String otherEmail : otherEmails)
									{
										System.out.println("ZiaOrgEnrichment EnrichedData OtherEmails : " + otherEmail);
									}
								}
								
								System.out.println("ZiaOrgEnrichment EnrichedData SignIn : " + enrichedData.getSignIn());
								System.out.println("ZiaOrgEnrichment EnrichedData Website : " + enrichedData.getWebsite());
								
								List<Address> address = enrichedData.getAddress();
								if(address != null)
								{
									for(Address address1 : address)
									{
										System.out.println("ZiaOrgEnrichment EnrichedData Address Country : " + address1.getCountry());
										System.out.println("ZiaOrgEnrichment EnrichedData Address City : " + address1.getCity());
										System.out.println("ZiaOrgEnrichment EnrichedData Address PinCode : " + address1.getPinCode());
										System.out.println("ZiaOrgEnrichment EnrichedData Address State : " + address1.getState());
										System.out.println("ZiaOrgEnrichment EnrichedData Address FillAddress : " + address1.getFillAddress());
									}
								}
								System.out.println("ZiaOrgEnrichment EnrichedData SignUp : " + enrichedData.getSignUp());
								System.out.println("ZiaOrgEnrichment EnrichedData OrgType : " + enrichedData.getOrgType());
								List<Address> headQuarters = enrichedData.getHeadQuarters();
								if(headQuarters != null)
								{
									for(Address headQuarters1 : headQuarters)
									{
										System.out.println("ZiaOrgEnrichment EnrichedData HeadQuarters Country : " + headQuarters1.getCountry());
										System.out.println("ZiaOrgEnrichment EnrichedData HeadQuarters City : " + headQuarters1.getCity());
										System.out.println("ZiaOrgEnrichment EnrichedData HeadQuarters PinCode : " + headQuarters1.getPinCode());
										System.out.println("ZiaOrgEnrichment EnrichedData HeadQuarters State : " + headQuarters1.getState());
										System.out.println("ZiaOrgEnrichment EnrichedData HeadQuarters FillAddress : " + headQuarters1.getFillAddress());
									}
								}
								System.out.println("ZiaOrgEnrichment EnrichedData NoOfEmployees : " + enrichedData.getNoOfEmployees());
								List<String> territoryList = enrichedData.getTerritoryList();
								if(territoryList != null)
								{
									for(String territory : territoryList)
									{
										System.out.println("ZiaOrgEnrichment EnrichedData TerritoryList : " + territory);
									}
								}
								System.out.println("ZiaOrgEnrichment EnrichedData FoundingYear : " + enrichedData.getFoundingYear());
								List<Industry> industries = enrichedData.getIndustries();
								if(industries != null)
								{
									for(Industry industry : industries)
									{
										System.out.println("ZiaOrgEnrichment EnrichedData Industries Name : " + industry.getName());
										System.out.println("ZiaOrgEnrichment EnrichedData Industries Description : " + industry.getDescription());
									}
								}
								System.out.println("ZiaOrgEnrichment EnrichedData Name : " + enrichedData.getName());
								System.out.println("ZiaOrgEnrichment EnrichedData PrimaryEmail : " + enrichedData.getPrimaryEmail());
								List<String> businessModel = enrichedData.getBusinessModel();
								if(businessModel != null)
								{
									for(String businessModel1 : businessModel)
									{
										System.out.println("ZiaOrgEnrichment EnrichedData BusinessModel : " + businessModel1);
									}
								}
								System.out.println("ZiaOrgEnrichment EnrichedData PrimaryContact : " + enrichedData.getPrimaryContact());
								List<SocialMedia> socialMedia = enrichedData.getSocialMedia();
								if(socialMedia != null)
								{
									for(SocialMedia socialMedia1 : socialMedia)
									{
										System.out.println("ZiaOrgEnrichment EnrichedData SocialMedia MediaType : " + socialMedia1.getMediaType());
										List<String> mediaUrl = socialMedia1.getMediaUrl();
										if(mediaUrl != null)
										{
											for(String mediaUrl1 : mediaUrl)
											{
												System.out.println("ZiaOrgEnrichment EnrichedData SocialMedia MediaUrl: " + mediaUrl1);
											}
										}
									}
								}
							}
							
							EnrichBasedOn enrichBasedOn = ziaorgenrichment1.getEnrichBasedOn();
							if(enrichBasedOn != null)
							{
								System.out.println("ZiaOrgEnrichment EnrichBasedOn Name : " + enrichBasedOn.getName());
								System.out.println("ZiaOrgEnrichment EnrichBasedOn Email : " + enrichBasedOn.getEmail());
								System.out.println("ZiaOrgEnrichment EnrichBasedOn Website : " + enrichBasedOn.getWebsite());
							}
							
							System.out.println("ZiaOrgEnrichment Id : " + ziaorgenrichment1.getId());
							System.out.println("ZiaOrgEnrichment Status : " + ziaorgenrichment1.getStatus());
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
			else if (response.getStatusCode() != 204)
			{
				Model responseObject = response.getModel();
				Class<? extends Model> clas = responseObject.getClass();
				Field[] fields = clas.getDeclaredFields();
				for (Field field1 : fields)
				{
					field1.setAccessible(true);
					System.out.println(field1.getName() + ":" + field1.get(responseObject));
				}
			}
		}
	}

	public static void main(String[] args)
	{
		try
		{
			Environment environment = USDataCenter.PRODUCTION;
			Token token = new OAuthToken.Builder().clientID("Client_Id").clientSecret("Client_Secret").refreshToken("Refresh_Token").build();
			new Initializer.Builder().environment(environment).token(token).initialize();
			Long ziaOrgEnrichmentId = 34794003l;
			getZiaOrgEnrichment(ziaOrgEnrichmentId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
