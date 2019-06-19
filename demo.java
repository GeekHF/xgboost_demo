package xgboost_demo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import ml.dmlc.xgboost4j.java.Booster;
import ml.dmlc.xgboost4j.java.DMatrix;
import ml.dmlc.xgboost4j.java.XGBoost;
import ml.dmlc.xgboost4j.java.XGBoostError;

public class demo {
	public static void main(String[] args) throws XGBoostError {
		Booster _booster;
		_booster = load_model("./model/demo.model");
		for(int k=0; k<3000; k++){
			Random rand=new Random(100);
			float[] falist = new float[30];
			for(int i=0; i<30; i++) {
				falist[i] = (float) ((rand.nextFloat() - 0.5)/5);
			}

			int nrow = 1;
			int ncol = 30;
			DMatrix dmat = null;
			try {
				dmat = new DMatrix(falist, nrow, ncol, Float.NaN);
			} catch (XGBoostError e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			float[][] predict = new float[1][1];
			long startTime = System.nanoTime();
			try {
				predict = _booster.predict(dmat);
			} catch (XGBoostError e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			long endTime = System.nanoTime();
			long duration = (endTime - startTime)/1000;

			File file = new File("./duration.txt");
			FileWriter fr;
			try {
				fr = new FileWriter(file, true);
				BufferedWriter br = new BufferedWriter(fr);
				PrintWriter pr = new PrintWriter(br);
				pr.println(duration);
				pr.close();
				br.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(duration);
		}
	}

	public static Booster load_model(String path) throws XGBoostError {
		return XGBoost.loadModel(path);
	}
}
