package com.tmf.sms.app;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.tmf.sms.daos.StudentsDAO;
import com.tmf.sms.services.StudentServices;

public class SMSApp {
	public static void main(String[] args){
		StudentServices service = new StudentServices();
		service.menu();
	}
}
