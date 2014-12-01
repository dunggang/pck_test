package org.mixare;

import java.text.DecimalFormat;

import org.mixare.GTAData.AllData;
import org.mixare.lib.MixUtils;
import org.mixare.lib.gui.PaintScreen;
import org.mixare.lib.gui.TextObj;

import android.graphics.Color;
import android.graphics.Path;
import android.location.Location;
import android.util.Log;

public class chunMarker extends LocalMarker{


	public static final int MAX_OBJECTS = 20;
	public static final int OSM_URL_MAX_OBJECTS = 5;
	int i=0;
	int z=0;
	int y=0;
	int arr[]= new int[100];

	public chunMarker(String id, String title, double latitude,
			double longitude, double altitude) {
		super(id, title, latitude, longitude, altitude, title);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(Location curGPSFix) {
		super.update(curGPSFix);
	}
	@Override
	public int getMaxObjects() {
		// TODO Auto-generated method stub
		return MAX_OBJECTS;
	}



	//Text 바꾸는곳
	@Override
	public void drawTextBlock(PaintScreen dw) {
		float maxHeight = Math.round(dw.getHeight() / 10f) + 1;
		// TODO: change textblock only when distance changes

		String textStr = "";

		double d = distance;


		DecimalFormat df = new DecimalFormat("@#");
		//	if (d < 1000.0) {
		//	textStr = "박천경" + " (" + df.format(d) + "M)";
		textStr = title +" (" + df.format(d) +"m)"; //원래
		/*	} else {
				d = d / 1000.0;
				textStr = title + " (" + df.format(d) + "km)";
			}

		 */
		//				System.out.println(distance);
		//		

		textBlock = new TextObj(textStr, Math.round(maxHeight / 2f) + 1, 250,
				dw, underline);

		if (isVisible) {
			// based on the distance set the colour
			if (distance < 100.0) {
				textBlock.setBgColor(Color.argb(128, 52, 52, 52));
				textBlock.setBorderColor(Color.rgb(255, 104, 91));
			} else {
				textBlock.setBgColor(Color.argb(128, 0, 0, 0));
				textBlock.setBorderColor(Color.rgb(255, 255, 255));
			}
			//dw.setColor(DataSource.getColor(type));

			float currentAngle = MixUtils.getAngle(cMarker.x, cMarker.y,
					signMarker.x, signMarker.y);
			txtLab.prepare(textBlock);
			dw.setStrokeWidth(1f);
			dw.setFill(true);
			//이름 적히는 위치
//			for(z=0;z<AllData.mData.MakerList.size();z++)
//			{
//				arr[z]=(int) cMarker.x;
//				System.out.println("----------------"+z);
//
//			}

//			for(y=0;y<AllData.mData.MakerList.size();y++)
//			{
//
//				if(cMarker.x-500<arr[y] &&arr[y]<cMarker.x+500)
//				{
					dw.paintObj(txtLab,cMarker.x-250 ,
							cMarker.y+50 , currentAngle + 90, 1);
					//System.out.println(arr[z]);
//					System.out.println(arr[z]);
//				}
//				else
//				{
//					dw.paintObj(txtLab,cMarker.x+900 ,
//							cMarker.y+900 , currentAngle + 90, 1);
//					System.out.println("Hi====================");
//				}
//			}
		}
		//				dw.paintObj(txtLab, signMarker.x - txtLab.getWidth() / 2,
		//						signMarker.y + maxHeight*2, currentAngle + 90, 1);

	}
}


