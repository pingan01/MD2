package com.min3d_objloader;

import android.os.Bundle;
import min3d.core.Object3dContainer;
import min3d.core.RendererActivity;
import min3d.parser.IParser;
import min3d.parser.Parser;
import min3d.vos.Light;

public class Obj3DView extends RendererActivity {
private Object3dContainer faceObject3D;


@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
}

@Override
public void initScene() {
	
	scene.lights().add(new Light());

    Light myLight = new Light();
    myLight.position.setZ(-100);
    scene.lights().add(myLight);

    IParser myParser = Parser.createParser(Parser.Type.OBJ, getResources(), "com.min3d_objloader:raw/banana_chiquita_obj",true);
   // IParser myParser = Parser.createParser(Parser.Type.OBJ, getResources(), "com.min3d_objloader:raw/dice_obj",true);
    myParser.parse();
    
    faceObject3D = myParser.getParsedObject();
    faceObject3D.position().x = faceObject3D.position().y = faceObject3D.position().z = 0;
  //  faceObject3D.scale().x = faceObject3D.scale().y = faceObject3D.scale().z = 0.009f;
    faceObject3D.scale().x = faceObject3D.scale().y = faceObject3D.scale().z = 0.09f;
    scene.addChild(faceObject3D);
    
}

 @Override
 public void updateScene() {
     faceObject3D.rotation().x += 0.5;
     faceObject3D.rotation().z += 1;
//	 faceObject3D.rotation().x = 0.5f;
	// faceObject3D.rotation().z = 1f;
 }
    
    
}



