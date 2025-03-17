package samples.wizards;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zoho.api.authenticator.OAuthToken;
import com.zoho.api.authenticator.Token;
import com.zoho.crm.api.Initializer;
import com.zoho.crm.api.ParameterMap;
import com.zoho.crm.api.dc.USDataCenter;
import com.zoho.crm.api.dc.DataCenter.Environment;
import com.zoho.crm.api.fields.Fields;
import com.zoho.crm.api.layouts.Layouts;
import com.zoho.crm.api.modules.Modules;
import com.zoho.crm.api.profiles.Profile;
import com.zoho.crm.api.users.MinifiedUser;
import com.zoho.crm.api.util.APIResponse;
import com.zoho.crm.api.util.Model;
import com.zoho.crm.api.wizards.APIException;
import com.zoho.crm.api.wizards.Button;
import com.zoho.crm.api.wizards.ChartData;
import com.zoho.crm.api.wizards.Container;
import com.zoho.crm.api.wizards.Criteria;
import com.zoho.crm.api.wizards.Node;
import com.zoho.crm.api.wizards.ResponseHandler;
import com.zoho.crm.api.wizards.ResponseWrapper;
import com.zoho.crm.api.wizards.Screen;
import com.zoho.crm.api.wizards.Segment;
import com.zoho.crm.api.wizards.Wizard;
import com.zoho.crm.api.wizards.WizardsOperations;

public class GetWizard
{
	public static void getWizard(String wizardId) throws Exception
	{
		WizardsOperations wizardsOperations = new WizardsOperations();
		ParameterMap paramInstance = new ParameterMap();
		paramInstance.add(WizardsOperations.GetWizardByIDParam.LAYOUT_ID, "3477061091055");
		APIResponse<ResponseHandler> response = wizardsOperations.getWizardById(wizardId, paramInstance);
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
					List<Wizard> wizards = responseWrapper.getWizards();
					for (Wizard wizard : wizards)
					{
						System.out.println("Wizard CreatedTime: " + wizard.getCreatedTime());
						System.out.println("Wizard ModifiedTime: " + wizard.getModifiedTime());
						Modules module = wizard.getModule();
						if (module != null)
						{
							System.out.println("Wizard Module ID: " + module.getId());
							System.out.println("Wizard Module apiName: " + module.getAPIName());
						}
						System.out.println("Wizard Name: " + wizard.getName());
						MinifiedUser modifiedBy = wizard.getModifiedBy();
						if (modifiedBy != null)
						{
							System.out.println("Wizard Modified By Name : " + modifiedBy.getName());
							System.out.println("Wizard Modified By id : " + modifiedBy.getId());
							System.out.println("Wizard Modified By Name : " + modifiedBy.getEmail());
						}
						List<Profile> profiles = wizard.getProfiles();
						for (Profile profile : profiles)
						{
							System.out.println("Wizard Profile  Name: " + profile.getName());
							System.out.println("Wizard Profile ID: " + profile.getId());
						}
						System.out.println("Wizard Active: " + wizard.getActive());
						List<Container> containers = wizard.getContainers();
						for (Container container : containers)
						{
							System.out.println("Wizard Container ID: " + container.getId());
							Layouts layout = container.getLayout();
							if (layout != null)
							{
								System.out.println("Wizard Container Layout ID: " + layout.getId());
								System.out.println("Wizard Container Layout Name: " + layout.getName());
							}
							ChartData chartData = container.getChartData();
							if (chartData != null)
							{
								List<Node> nodes = chartData.getNodes();
								for (Node node : nodes)
								{
									System.out.println("Chart Data Node poistion y: " + node.getPosY());
									System.out.println("Chart Data Node poistion X: " + node.getPosX());
									System.out.println("Chart Data Node start node: " + node.getStartNode());
									Screen nodeScreen = node.getScreen();
									if (nodeScreen != null)
									{
										System.out.println(" screens id: " + nodeScreen.getId());
										System.out.println("display label: " + nodeScreen.getDisplayLabel());
									}
								}
								List<com.zoho.crm.api.wizards.Connection> connections = chartData.getConnections();
								if (connections != null)
								{
									for (com.zoho.crm.api.wizards.Connection connection : connections)
									{
										Screen connectionScreen = connection.getTargetScreen();
										if (connectionScreen != null)
										{
											System.out.println(" screens id: " + connectionScreen.getId());
											System.out.println("display label: " + connectionScreen.getDisplayLabel());
										}
										Button connectionButton = connection.getSourceButton();
										if (connectionButton != null)
										{
											System.out.println(" button id: " + connectionButton.getId());
											System.out.println("display label: " + connectionButton.getDisplayLabel());
										}
									}
								}
								System.out.println("Chart Data Canvas width: " + chartData.getCanvasWidth());
								System.out.println("Chart Data Canvas height: " + chartData.getCanvasHeight());
							}
							List<Screen> screens = container.getScreens();
							if (screens != null)
							{
								for (Screen screen : screens)
								{
									System.out.println(" screens id: " + screen.getId());
									System.out.println("display label: " + screen.getDisplayLabel());
									List<Segment> segments = screen.getSegments();
									for (Segment segment : segments)
									{
										System.out.println("screens segment id: " + segment.getId());
										System.out.println("screens segment equence number: " + segment.getSequenceNumber());
										System.out.println("screens segment display label: " + segment.getDisplayLabel());
										System.out.println("screens segment type: " + segment.getType());
										System.out.println("screens segment column count: " + segment.getColumnCount());
										List<Fields> fields = segment.getFields();
										if (fields != null)
										{
											for (Fields field : fields)
											{
												System.out.println("screens segment field id: " + field.getId());
												System.out.println("screens segment field apiname: " + field.getAPIName());
											}
										}
										List<Button> buttons = segment.getButtons();
										if (buttons != null)
										{
											for (Button button : buttons)
											{
												Criteria criteria = button.getCriteria();
												if (criteria != null)
												{
													printCriteria(criteria);
												}
												Screen targetScreen = button.getTargetScreen();
												if (targetScreen != null)
												{
													System.out.println(" Button targetScreen id : " + targetScreen.getId());
													System.out.println(" Button targetScreen display label: " + targetScreen.getDisplayLabel());
												}
												System.out.println(" Button display label: " + button.getDisplayLabel());
												System.out.println(" Button id: " + button.getId());
												System.out.println(" Button display label: " + button.getDisplayLabel());
												System.out.println(" Button type: " + button.getType());
												System.out.println(" Button bg color: " + button.getBackgroundColor());
												System.out.println(" Button sequence number: " + button.getSequenceNumber());
												System.out.println(" Button color: " + button.getColor());
												System.out.println(" Button shape: " + button.getShape());
												System.out.println(" Button sequence number: " + button.getSequenceNumber());
											}
										}
									}
								}
							}
						}
						MinifiedUser createdBy = wizard.getCreatedBy();
						if (createdBy != null)
						{
							System.out.println("Wizard Created By Name : " + createdBy.getName());
							System.out.println("Wizard Created By id : " + createdBy.getId());
							System.out.println("Wizard Created By Name : " + createdBy.getEmail());
						}
						Wizard parentWizard = wizard.getParentWizard();
						if (parentWizard != null)
						{
							System.out.println("Wizard Folder  id : " + parentWizard.getId());
							System.out.println("Wizard Folder  Name : " + parentWizard.getName());
						}
						System.out.println("Wizard Draft: " + wizard.getDraft());
						System.out.println("Wizard ID: " + wizard.getId());
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
					System.out.println("Message: " + exception.getMessage().getValue());
				}
			}
			else
			{
				Model responseObject = response.getModel();
				Class<? extends Model> clas = responseObject.getClass();
				java.lang.reflect.Field[] Fields = clas.getDeclaredFields();
				for (java.lang.reflect.Field field : Fields)
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
			Token token = new OAuthToken.Builder().clientID("Client_Id").clientSecret("Client_Secret").refreshToken("Refresh_Token").build();
			new Initializer.Builder().environment(environment).token(token).initialize();
			String wizardId = "34770619497009";
			getWizard(wizardId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
