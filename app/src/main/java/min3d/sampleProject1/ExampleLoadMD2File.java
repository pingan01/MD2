package min3d.sampleProject1;

import min3d.animation.AnimationObject3d;
import min3d.core.Object3dContainer;
import min3d.core.RendererActivity;
import min3d.parser.IParser;
import min3d.parser.Parser;
import min3d.vos.Light;

public class ExampleLoadMD2File extends RendererActivity {
	private AnimationObject3d ogre;

	@Override
	public void initScene() {
		scene.backgroundColor().setAll(0x00000000);
		scene.lights().add(new Light());//设置灯光，否则一片黑，看不见  
		
		IParser parser = Parser.createParser(Parser.Type.MD2,
				getResources(), "min3d.sampleProject1:raw/solder", false);
		parser.parse();

		ogre = parser.getParsedAnimationObject();
		ogre.scale().x = ogre.scale().y = ogre.scale().z = .07f;////控制模型缩放率---
		//控制模型显示角度与方向
		ogre.rotation().z = -90;//模型前后方向
		ogre.rotation().x = -90;
		scene.addChild(ogre);
		ogre.setFps(10);//控制动画帧率
		ogre.play();
	}

	@Override
	public void updateScene() {

	}

}
