package samples.ziapeopleenrichment;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;

import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.ziapeopleenrichment.APIException;
import com.zoho.crm.api.ziapeopleenrichment.Address;
import com.zoho.crm.api.ziapeopleenrichment.Company;
import com.zoho.crm.api.ziapeopleenrichment.CompanyInfo;
import com.zoho.crm.api.ziapeopleenrichment.EmailInfo;
import com.zoho.crm.api.ziapeopleenrichment.EnrichBasedOn;
import com.zoho.crm.api.ziapeopleenrichment.EnrichedData;
import com.zoho.crm.api.ziapeopleenrichment.Experience;
import com.zoho.crm.api.ziapeopleenrichment.Industry;
import com.zoho.crm.api.ziapeopleenrichment.ZiaPeopleEnrichmentOperations;
import com.zoho.crm.api.ziapeopleenrichment.ResponseHandler;
import com.zoho.crm.api.ziapeopleenrichment.ResponseWrapper;
import com.zoho.crm.api.ziapeopleenrichment.Social;
import com.zoho.crm.api.ziapeopleenrichment.SocialMedia;
import com.zoho.crm.api.ziapeopleenrichment.ZiaPeopleEnrichment;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;

public class GetZiaPeopleEnrichment
{
	public static void getZiaPeopleEnrichment(Long ziaPeopleEnrichmentId) throws Exception
	{
		ZiaPeopleEnrichmentOperations ziaPeopleEnrichmentOperations = new ZiaPeopleEnrichmentOperations();
		APIResponse<ResponseHandler> response = ziaPeopleEnrichmentOperations.getZiaPeopleEnrichment(ziaPeopleEnrichmentId);
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
					List<ZiaPeopleEnrichment> ziapeopleenrichment = responseWrapper.getZiaPeopleEnrichment();
					if(ziapeopleenrichment != null)
					{
						for(ZiaPeopleEnrichment ziapeopleenrichment1 : ziapeopleenrichment)
						{
							EnrichedData enrichedData = ziapeopleenrichment1.getEnrichedData();
							if(enrichedData != null)
							{
								System.out.println("ZiaPeopleEnrichment EnrichedData Website : " + enrichedData.getWebsite());
								List<EmailInfo> emailInfos = enrichedData.getEmailInfos();
								if(emailInfos != null)
								{
									for(EmailInfo emailInfo : emailInfos)
									{
										System.out.println("ZiaPeopleEnrichment EnrichedData EmailInfo Type : " + emailInfo.getType());
										System.out.println("ZiaPeopleEnrichment EnrichedData EmailInfo Email : " + emailInfo.getEmail());	
									}
								}
								System.out.println("ZiaPeopleEnrichment EnrichedData Gender : " + enrichedData.getGender());
								CompanyInfo companyInfo = enrichedData.getCompanyInfo();
								if(companyInfo != null)
								{
									System.out.println("ZiaPeopleEnrichment EnrichedData CompanyInfo Name : " + companyInfo.getName());
									List<Industry> industries = companyInfo.getIndustries();
									if(industries != null)
									{
										for(Industry industry : industries)
										{
											System.out.println("ZiaPeopleEnrichment EnrichedData CompanyInfo Industries Name : " + industry.getName());
											System.out.println("ZiaPeopleEnrichment EnrichedData CompanyInfo Industries Description : " + industry.getDescription());
										}
									}
									
									List<Experience> experiences = companyInfo.getExperiences();
									if(experiences != null)
									{
										for(Experience experience : experiences)
										{
											System.out.println("ZiaPeopleEnrichment EnrichedData CompanyInfo Experience EndDate : " + experience.getEndDate());
											System.out.println("ZiaPeopleEnrichment EnrichedData CompanyInfo Experience CompanyName : " + experience.getCompanyName());
											System.out.println("ZiaPeopleEnrichment EnrichedData CompanyInfo Experience Title : " + experience.getTitle());
											System.out.println("ZiaPeopleEnrichment EnrichedData CompanyInfo Experience StartDate : " + experience.getStartDate());
											System.out.println("ZiaPeopleEnrichment EnrichedData CompanyInfo Experience Primary : " + experience.getPrimary());
										}
									}
								}
								System.out.println("ZiaPeopleEnrichment EnrichedData LastName : " + enrichedData.getLastName());
								List<Object> educations = enrichedData.getEducations();
								if(educations != null)
								{
									System.out.println("ZiaPeopleEnrichment EnrichedData Educations : ");
									System.out.println(educations);
								}
								System.out.println("ZiaPeopleEnrichment EnrichedData MiddleName : " + enrichedData.getMiddleName());
								List<Object> skills = enrichedData.getSkills();
								if(skills != null)
								{
									System.out.println("ZiaPeopleEnrichment EnrichedData Skills : ");
									System.out.println(skills);
								}
								List<String> otherContacts = enrichedData.getOtherContacts();
								if(otherContacts != null)
								{
									for(String otherContact : otherContacts)
									{
										System.out.println("ZiaPeopleEnrichment EnrichedData OtherContacts : " + otherContact);
									}
								}
								List<Address> addressListInfo = enrichedData.getAddressListInfo();
								if(addressListInfo != null)
								{
									for(Address addressListInfo1 : addressListInfo)
									{
										System.out.println("ZiaPeopleEnrichment EnrichedData AddressListInfo Continent : " + addressListInfo1.getContinent());
										System.out.println("ZiaPeopleEnrichment EnrichedData AddressListInfo Country : " + addressListInfo1.getCountry());
										System.out.println("ZiaPeopleEnrichment EnrichedData AddressListInfo Name : " + addressListInfo1.getName());
										System.out.println("ZiaPeopleEnrichment EnrichedData AddressListInfo Region : " + addressListInfo1.getRegion());
										System.out.println("ZiaPeopleEnrichment EnrichedData AddressListInfo Primary : " + addressListInfo1.getPrimary());
									}
								}
								Address primaryAddressInfo = enrichedData.getPrimaryAddressInfo();
								if(primaryAddressInfo != null)
								{
									System.out.println("ZiaPeopleEnrichment EnrichedData PrimaryAddressInfo Continent : " + primaryAddressInfo.getContinent());
									System.out.println("ZiaPeopleEnrichment EnrichedData PrimaryAddressInfo Country : " + primaryAddressInfo.getCountry());
									System.out.println("ZiaPeopleEnrichment EnrichedData PrimaryAddressInfo Name : " + primaryAddressInfo.getName());
									System.out.println("ZiaPeopleEnrichment EnrichedData PrimaryAddressInfo Region : " + primaryAddressInfo.getRegion());
									System.out.println("ZiaPeopleEnrichment EnrichedData PrimaryAddressInfo Primary : " + primaryAddressInfo.getPrimary());
								}
								System.out.println("ZiaPeopleEnrichment EnrichedData Name : " + enrichedData.getName());
								System.out.println("ZiaPeopleEnrichment EnrichedData SecondaryContact : " + enrichedData.getSecondaryContact());
								System.out.println("ZiaPeopleEnrichment EnrichedData PrimaryEmail : " + enrichedData.getPrimaryEmail());
								System.out.println("ZiaPeopleEnrichment EnrichedData Designation : " + enrichedData.getDesignation());
								System.out.println("ZiaPeopleEnrichment EnrichedData Id : " + enrichedData.getId());
								List<Object> interests = enrichedData.getInterests();
								if(interests != null)
								{
									System.out.println("ZiaPeopleEnrichment EnrichedData Interests : ");
									System.out.println(interests);
								}
								System.out.println("ZiaPeopleEnrichment EnrichedData FirstName : " + enrichedData.getFirstName());
								System.out.println("ZiaPeopleEnrichment EnrichedData PrimaryContact : " + enrichedData.getPrimaryContact());
								List<SocialMedia> socialMedia = enrichedData.getSocialMedia();
								if(socialMedia != null)
								{
									for(SocialMedia socialMedia1 : socialMedia)
									{
										System.out.println("ZiaPeopleEnrichment EnrichedData SocialMedia MediaType : " + socialMedia1.getMediaType());
										List<String> mediaUrl = socialMedia1.getMediaUrl();
										if(mediaUrl != null)
										{
											for(String mediaUrl1 : mediaUrl)
											{
												System.out.println("ZiaPeopleEnrichment EnrichedData SocialMedia MediaUrl: " + mediaUrl1);
											}
										}
									}
								}
							}
							EnrichBasedOn enrichBasedOn = ziapeopleenrichment1.getEnrichBasedOn();
							if(enrichBasedOn != null)
							{
								Social social = enrichBasedOn.getSocial();
								if(social != null)
								{
									System.out.println("ZiaPeopleEnrichment EnrichBasedOn Social Facebook : " + social.getFacebook());
									System.out.println("ZiaPeopleEnrichment EnrichBasedOn Social Linkedin : " + social.getLinkedin());
									System.out.println("ZiaPeopleEnrichment EnrichBasedOn Social Twitter : " + social.getTwitter());
								}
								System.out.println("ZiaPeopleEnrichment EnrichBasedOn Name : " + enrichBasedOn.getName());
								Company company = enrichBasedOn.getCompany();
								if(company != null)
								{
									System.out.println("ZiaPeopleEnrichment EnrichBasedOn Company Website : " + company.getWebsite());
									System.out.println("ZiaPeopleEnrichment EnrichBasedOn Company Name : " + company.getName());
								}
								System.out.println("ZiaPeopleEnrichment EnrichBasedOn Email : " + enrichBasedOn.getEmail());
							}
							
							System.out.println("ZiaPeopleEnrichment Id : " + ziapeopleenrichment1.getId());
							System.out.println("ZiaPeopleEnrichment Status : " + ziapeopleenrichment1.getStatus());
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
			Long ziaPeopleEnrichmentId = 34794003l;
			getZiaPeopleEnrichment(ziaPeopleEnrichmentId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
