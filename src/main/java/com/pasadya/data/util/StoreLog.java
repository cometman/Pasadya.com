package com.pasadya.data.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StoreLog {

	private static BufferedWriter _out;
	private static StoreLog instance;
	private static File logFile = new File("storeLog.log");
	private static FileWriter fw;
	private Date dateStamp;
	private SimpleDateFormat sdf = new SimpleDateFormat("MM-DD-YYYY HH-MM");

	private StoreLog() {

	}

	public void writeToLog(String message) {
		try {
			dateStamp = new Date();
			fw = new FileWriter(logFile);

			if (_out == null) {
				_out = new BufferedWriter(fw);
			}
			_out.append(sdf.format(dateStamp) + ": ");
			_out.append(message);
			_out.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void close() {
		try {
			if (_out != null) {

				fw.flush();
				_out.close();
				fw.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static StoreLog getInstance() {
		if (instance == null) {
			instance = new StoreLog();
		}
		return instance;
	}
}
