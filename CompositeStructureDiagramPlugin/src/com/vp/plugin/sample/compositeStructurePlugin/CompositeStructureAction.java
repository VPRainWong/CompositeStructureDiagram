package com.vp.plugin.sample.compositeStructurePlugin;

import java.awt.Point;

import com.vp.plugin.ApplicationManager;
import com.vp.plugin.DiagramManager;
import com.vp.plugin.action.VPAction;
import com.vp.plugin.action.VPActionController;
import com.vp.plugin.diagram.ICaptionUIModel;
import com.vp.plugin.diagram.ICompositeStructureDiagramUIModel;
import com.vp.plugin.diagram.IDiagramTypeConstants;
import com.vp.plugin.diagram.shape.IBaseStructuredClassUIModel;
import com.vp.plugin.diagram.shape.IPartUIModel;
import com.vp.plugin.diagram.shape.IPortUIModel;
import com.vp.plugin.model.IAssociation;
import com.vp.plugin.model.IAttribute;
import com.vp.plugin.model.IClass;
import com.vp.plugin.model.IModel;
import com.vp.plugin.model.IPort;
import com.vp.plugin.model.factory.IModelElementFactory;

public class CompositeStructureAction implements VPActionController{

	@Override
	public void performAction(VPAction arg0) {
		//Create blank diagram
		DiagramManager diagramManager = ApplicationManager.instance().getDiagramManager();
		ICompositeStructureDiagramUIModel composite = (ICompositeStructureDiagramUIModel) diagramManager.createDiagram(IDiagramTypeConstants.DIAGRAM_TYPE_COMPOSITE_STRUCTURE_DIAGRAM);
		composite.setName("Sample Composite Structure Diagram");
		
		
		//Create model
		IModel model = IModelElementFactory.instance().createModel();
		model.setName("Sample Composite Structure Diagram - Car");
		//Add the diagram to the model
		model.addSubDiagram(composite);
		
		//Create Class
		IClass classCar = IModelElementFactory.instance().createClass();
		classCar.setName("Car");
		classCar.setVisibility(IClass.VISIBILITY_PUBLIC);
		//make the class a child the model
		model.addChild(classCar);
		//Create shape on diagram
		IBaseStructuredClassUIModel shapeClassCar = (IBaseStructuredClassUIModel) diagramManager.createDiagramElement(composite, classCar);
		shapeClassCar.setBounds(100, 50, 350, 200);
		shapeClassCar.resetCaption();
		
		//Create Part Transmission
		//Create the class of the part
		IClass classTransmission = IModelElementFactory.instance().createClass();
		classTransmission.setName("Transmission");
		classTransmission.setVisibility(IClass.VISIBILITY_PUBLIC);
		//make the part's class a child of the model
		model.addChild(classTransmission);
		//Create the Attribute of the part
		IAttribute partTransmission = IModelElementFactory.instance().createAttribute();
		partTransmission.setName("t");
		partTransmission.setVisibility(IAttribute.VISIBILITY_PRIVATE);
		partTransmission.setType(classTransmission);
		partTransmission.setScope(IAttribute.SCOPE_INSTANCE);
		partTransmission.setAggregation(IAttribute.AGGREGATION_COMPOSITED);
		//Add the attribute to the corresponding class
		classCar.addAttribute(partTransmission);
		//Create the shape on diagram
		IPartUIModel shapePartTransmission = (IPartUIModel) diagramManager.createDiagramElement(composite, partTransmission);
		shapePartTransmission.setBounds(125, 100, 125, 50);
		shapePartTransmission.resetCaption();
		//Make the shape as a child of the shape Car
		shapeClassCar.addChild(shapePartTransmission);
		
		//Create Ports for Transmission
		//Create the port from the part
		IPort portTransmissionLeft = partTransmission.createPort();
		portTransmissionLeft.setVisibility(IPort.VISIBILITY_PUBLIC);
		portTransmissionLeft.setService(true);
		//Create shape on diagram
		IPortUIModel shapePortTransmissionLeft= (IPortUIModel) diagramManager.createDiagramElement(composite, portTransmissionLeft);
		shapePortTransmissionLeft.setBounds(120, 120, 10, 10);
		//Make the port as a child of the part
		shapePartTransmission.addChild(shapePortTransmissionLeft);
		
		IPort portTransmissionRight = partTransmission.createPort();
		portTransmissionRight.setVisibility(IPort.VISIBILITY_PUBLIC);
		portTransmissionRight.setService(true);
		IPortUIModel shapePortTransmissionRight = (IPortUIModel) diagramManager.createDiagramElement(composite, portTransmissionRight);
		shapePortTransmissionRight.setBounds(245, 120, 10, 10);
		shapePartTransmission.addChild(shapePortTransmissionRight);
		
		
		//Create Part Engine
		IClass classEngine = IModelElementFactory.instance().createClass();
		classEngine.setName("Engine");
		classEngine.setVisibility(IClass.VISIBILITY_PUBLIC);
		model.addChild(classEngine);
		
		IAttribute partEngine = IModelElementFactory.instance().createAttribute();
		partEngine.setName("e");
		partEngine.setVisibility(IAttribute.VISIBILITY_PRIVATE);
		partEngine.setType(classEngine);
		partEngine.setScope(IAttribute.SCOPE_INSTANCE);
		partEngine.setAggregation(IAttribute.AGGREGATION_COMPOSITED);
		classCar.addAttribute(partEngine);
		IPartUIModel shapePartEngine = (IPartUIModel) diagramManager.createDiagramElement(composite, partEngine);
		shapePartEngine.setBounds(300, 100, 125, 50);
		shapePartEngine.resetCaption();
		shapeClassCar.addChild(shapePartEngine);
		
		//Create Ports for Engine
		IPort portEngineLeft = partEngine.createPort();
		portEngineLeft.setVisibility(IPort.VISIBILITY_PUBLIC);
		portEngineLeft.setService(true);
		IPortUIModel shapePortEngineLeft = (IPortUIModel) diagramManager.createDiagramElement(composite, portEngineLeft);
		shapePortEngineLeft.setBounds(295, 120, 10, 10);
		shapePartEngine.addChild(shapePortEngineLeft);
		
		IPort portEngineRight = partEngine.createPort();
		portEngineRight.setVisibility(IPort.VISIBILITY_PUBLIC);
		IPortUIModel shapePortEngineRight = (IPortUIModel) diagramManager.createDiagramElement(composite, portEngineRight);
		shapePortEngineRight.setBounds(420, 120, 10, 10);
		shapePartEngine.addChild(shapePortEngineRight);
		
		
		//Create Part Steering System
		IClass classSteeringSystem = IModelElementFactory.instance().createClass();
		classSteeringSystem.setName("Steering System");
		classSteeringSystem.setVisibility(IClass.VISIBILITY_PUBLIC);
		model.addChild(classSteeringSystem);
		
		IAttribute partSteeringSystem = IModelElementFactory.instance().createAttribute();
		partSteeringSystem.setName("s");
		partSteeringSystem.setVisibility(IAttribute.VISIBILITY_PRIVATE);
		partSteeringSystem.setType(classSteeringSystem);
		partSteeringSystem.setScope(IAttribute.SCOPE_INSTANCE);
		partSteeringSystem.setAggregation(IAttribute.AGGREGATION_COMPOSITED);
		classCar.addAttribute(partSteeringSystem);
		IPartUIModel shapePartSteeringSystem = (IPartUIModel) diagramManager.createDiagramElement(composite, partSteeringSystem);
		shapePartSteeringSystem.setBounds(125, 175, 125, 50);
		shapePartSteeringSystem.resetCaption();
		shapeClassCar.addChild(shapePartSteeringSystem);
		
		//Create Ports for Steering System
		IPort portSteeringSystemLeft = partSteeringSystem.createPort();
		portSteeringSystemLeft.setVisibility(IPort.VISIBILITY_PUBLIC);
		portSteeringSystemLeft.setService(true);
		IPortUIModel shapePortSteeringSystemLeft = (IPortUIModel) diagramManager.createDiagramElement(composite, portSteeringSystemLeft);
		shapePortSteeringSystemLeft.setBounds(120, 195, 10, 10);
		shapePartSteeringSystem.addChild(shapePortSteeringSystemLeft);
		
		IPort portSteeringSystemRight = partSteeringSystem.createPort();
		portSteeringSystemRight.setVisibility(IPort.VISIBILITY_PUBLIC);
		portSteeringSystemRight.setService(true);
		IPortUIModel shapePortSteeringSystemRight = (IPortUIModel) diagramManager.createDiagramElement(composite, portSteeringSystemRight);
		shapePortSteeringSystemRight.setBounds(245, 195, 10, 10);
		shapePartSteeringSystem.addChild(shapePortSteeringSystemRight);
		
		
		//Create Ports for Car and their Classes
		//Create Class for the Port
		IClass classWheel = IModelElementFactory.instance().createClass();
		classWheel.setName("Wheel");
		classWheel.setVisibility(IClass.VISIBILITY_PUBLIC);
		//Make the class a child of the model
		model.addChild(classWheel);
		//Create Port
		IPort portWheel1 = classCar.createPort();
		portWheel1.setVisibility(IPort.VISIBILITY_PUBLIC);
		portWheel1.setType(classWheel);
		portWheel1.setService(true);
		//Create shape on diagram
		IPortUIModel shapePortWheel1 = (IPortUIModel) diagramManager.createDiagramElement(composite, portWheel1);
		shapePortWheel1.setBounds(95, 120, 10, 10);
		shapePortWheel1.resetCaption();
		//make the caption displayed on the left hand side (west -> left)
		shapePortWheel1.getCaptionUIModel().setSide(ICaptionUIModel.SIDE_WEST);
		//Make the port shape as a child of the car's shape
		shapeClassCar.addChild(shapePortWheel1);
		
		IPort portWheel2 = classCar.createPort();
		portWheel2.setVisibility(IPort.VISIBILITY_PUBLIC);
		portWheel2.setType(classWheel);
		portWheel2.setService(true);
		IPortUIModel shapePortWheel2 = (IPortUIModel) diagramManager.createDiagramElement(composite, portWheel2);
		shapePortWheel2.setBounds(95, 195, 10, 10);
		shapePortWheel2.resetCaption();
		shapePortWheel2.getCaptionUIModel().setSide(ICaptionUIModel.SIDE_WEST);
		shapeClassCar.addChild(shapePortWheel2);
		
		IClass classGasPaddle = IModelElementFactory.instance().createClass();
		classGasPaddle.setName("Gas Paddle");
		classGasPaddle.setVisibility(IClass.VISIBILITY_PUBLIC);
		model.addChild(classGasPaddle);
		
		IPort portGasPaddle = classCar.createPort();
		portGasPaddle.setVisibility(IPort.VISIBILITY_PUBLIC);
		portGasPaddle.setType(classGasPaddle);
		portGasPaddle.setService(true);
		IPortUIModel shapePortGasPaddle = (IPortUIModel) diagramManager.createDiagramElement(composite, portGasPaddle);
		shapePortGasPaddle.setBounds(445, 120, 10, 10);
		shapePortGasPaddle.resetCaption();
		shapePortGasPaddle.getCaptionUIModel().setSide(ICaptionUIModel.SIDE_EAST);
		shapeClassCar.addChild(shapePortGasPaddle);
		
		
		IClass classSteeringWheel = IModelElementFactory.instance().createClass();
		classSteeringWheel.setName("Steering Wheel");
		classGasPaddle.setVisibility(IClass.VISIBILITY_PUBLIC);
		model.addChild(classSteeringWheel);
		
		IPort portSteeringWheel = classCar.createPort();
		portSteeringWheel.setVisibility(IPort.VISIBILITY_PUBLIC);
		portSteeringWheel.setType(classSteeringWheel);
		portSteeringWheel.setService(true);
		IPortUIModel shapePortSteeringWheel = (IPortUIModel) diagramManager.createDiagramElement(composite, portSteeringWheel);
		shapePortSteeringWheel.setBounds(445, 195, 10, 10);
		shapePortSteeringWheel.resetCaption();
		shapePortSteeringWheel.getCaptionUIModel().setSide(ICaptionUIModel.SIDE_EAST);
		shapeClassCar.addChild(shapePortSteeringWheel);
		
		
		//Create Association connecting Ports together
		IAssociation wheelToTransmition = IModelElementFactory.instance().createAssociation();
		//This association is connecting from the port wheel1...
		wheelToTransmition.setFrom(portWheel1);
		// the port on the left hand side of attribute transmission
		wheelToTransmition.setTo(portTransmissionLeft);
		//Create connector on diagram
		diagramManager.createConnector(composite, wheelToTransmition, shapePortWheel1, shapePortTransmissionLeft, new Point[] {new Point(105,125), new Point(120,125)});
		
		IAssociation transmitionToEngine = IModelElementFactory.instance().createAssociation();
		transmitionToEngine.setFrom(portTransmissionRight);
		transmitionToEngine.setTo(portEngineLeft);
		diagramManager.createConnector(composite, transmitionToEngine, shapePortTransmissionRight, shapePortEngineLeft, new Point[] {new Point(255,125), new Point(295,125)});
		
		IAssociation engineToGasPaddle = IModelElementFactory.instance().createAssociation();
		engineToGasPaddle.setFrom(portEngineRight);
		engineToGasPaddle.setTo(portGasPaddle);
		diagramManager.createConnector(composite, engineToGasPaddle, shapePortEngineRight, shapePortGasPaddle, new Point[] {new Point(430,125), new Point(445,125)});
		
		IAssociation wheelToSteeringSystem = IModelElementFactory.instance().createAssociation();
		wheelToSteeringSystem.setFrom(portWheel2);
		wheelToSteeringSystem.setTo(portSteeringSystemLeft);
		diagramManager.createConnector(composite, wheelToSteeringSystem, shapePortWheel2, shapePortSteeringSystemLeft, new Point[] {new Point(105,200), new Point(120,200)});
		
		IAssociation steeringSystemToSteeringWheel = IModelElementFactory.instance().createAssociation();
		steeringSystemToSteeringWheel.setFrom(portSteeringSystemRight);
		steeringSystemToSteeringWheel.setTo(portSteeringWheel);
		diagramManager.createConnector(composite, steeringSystemToSteeringWheel, shapePortSteeringSystemRight, shapePortSteeringWheel, new Point[] {new Point(255,200), new Point(445,200)});
		
		
		//Show up diagram
		diagramManager.openDiagram(composite);
	}

	@Override
	public void update(VPAction arg0) {
		// TODO Auto-generated method stub
		
	}

}
