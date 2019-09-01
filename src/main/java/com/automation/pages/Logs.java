package com.automation.pages;

import java.util.function.Supplier;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.message.MessageFactory;

import com.automation.utils.Config;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Logs implements Logger {
	private static Logger logger;
	public static Config config;
	public Logs(Object object) {
		logger=LogManager.getLogger(object);
	}
	
	public Logs(Object object,Config config) {
		this.config=config;
		logger=LogManager.getLogger(object);
	}
	public void catching(Level level, Throwable t) {
		// TODO Auto-generated method stub
	}

	
	public void catching(Throwable t) {
		// TODO Auto-generated method stub

	}

	
	public void debug(Marker marker, Message msg) {
		// TODO Auto-generated method stub

	}

	
	public void debug(Marker marker, Message msg, Throwable t) {
		// TODO Auto-generated method stub

	}

	
	public void debug(Marker marker, Object message) {
		// TODO Auto-generated method stub

	}

	
	public void debug(Marker marker, Object message, Throwable t) {
		// TODO Auto-generated method stub

	}

	
	public void debug(Marker marker, String message) {
		// TODO Auto-generated method stub

	}

	
	public void debug(Marker marker, String message, Object... params) {
		// TODO Auto-generated method stub

	}

	
	public void debug(Marker marker, String message, Throwable t) {
		// TODO Auto-generated method stub

	}

	
	public void debug(Message msg) {
		// TODO Auto-generated method stub

	}

	
	public void debug(Message msg, Throwable t) {
		// TODO Auto-generated method stub

	}

	
	public void debug(Object message) {
		// TODO Auto-generated method stub

	}

	
	public void debug(Object message, Throwable t) {
		// TODO Auto-generated method stub

	}

	

	
	public void debug(String message, Object... params) {
		// TODO Auto-generated method stub

	}

	
	public void debug(String message, Throwable t) {
		// TODO Auto-generated method stub

	}

	
	public void entry() {
		// TODO Auto-generated method stub

	}

	
	public void entry(Object... params) {
		// TODO Auto-generated method stub

	}

	
	public void error(Marker marker, Message msg) {
		// TODO Auto-generated method stub

	}

	
	public void error(Marker marker, Message msg, Throwable t) {
		// TODO Auto-generated method stub

	}

	
	public void error(Marker marker, Object message) {
		// TODO Auto-generated method stub

	}

	
	public void error(Marker marker, Object message, Throwable t) {
		// TODO Auto-generated method stub

	}

	
	public void error(Marker marker, String message) {
		// TODO Auto-generated method stub

	}

	
	public void error(Marker marker, String message, Object... params) {
		// TODO Auto-generated method stub

	}

	
	public void error(Marker marker, String message, Throwable t) {
		// TODO Auto-generated method stub

	}

	
	public void error(Message msg) {
		// TODO Auto-generated method stub

	}

	
	public void error(Message msg, Throwable t) {
		// TODO Auto-generated method stub

	}

	
	public void error(Object message) {
		// TODO Auto-generated method stub

	}

	
	public void error(Object message, Throwable t) {
		// TODO Auto-generated method stub

	}

	
	public void error(String message) {
		String mess = "" + message;
		config.getExtentTest().log(Status.ERROR, mess);
		logger.info(message);

	}

	
	public void error(String message, Object... params) {
		// TODO Auto-generated method stub

	}

	
	public void error(String message, Throwable t) {
		// TODO Auto-generated method stub

	}

	
	public void exit() {
		// TODO Auto-generated method stub

	}

	
	public <R> R exit(R result) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void fatal(Marker marker, Message msg) {
		// TODO Auto-generated method stub

	}

	
	public void fatal(Marker marker, Message msg, Throwable t) {
		// TODO Auto-generated method stub

	}

	
	public void fatal(Marker marker, Object message) {
		// TODO Auto-generated method stub

	}

	
	public void fatal(Marker marker, Object message, Throwable t) {
		// TODO Auto-generated method stub

	}

	
	public void fatal(Marker marker, String message) {
		// TODO Auto-generated method stub

	}

	
	public void fatal(Marker marker, String message, Object... params) {
		// TODO Auto-generated method stub

	}

	
	public void fatal(Marker marker, String message, Throwable t) {
		// TODO Auto-generated method stub

	}

	
	public void fatal(Message msg) {
		// TODO Auto-generated method stub

	}

	
	public void fatal(Message msg, Throwable t) {
		// TODO Auto-generated method stub

	}

	
	public void fatal(Object message) {
		// TODO Auto-generated method stub

	}

	
	public void fatal(Object message, Throwable t) {
		// TODO Auto-generated method stub

	}

	
	public void fatal(String message) {
		// TODO Auto-generated method stub

	}

	
	public void fatal(String message, Object... params) {
		// TODO Auto-generated method stub

	}

	
	public void fatal(String message, Throwable t) {
		// TODO Auto-generated method stub

	}

	
	public Level getLevel() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public MessageFactory getMessageFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void info(Marker marker, Message msg) {
		// TODO Auto-generated method stub

	}

	
	public void info(Marker marker, Message msg, Throwable t) {
		// TODO Auto-generated method stub

	}

	
	public void info(Marker marker, Object message) {
		// TODO Auto-generated method stub

	}

	
	public void info(Marker marker, Object message, Throwable t) {
		// TODO Auto-generated method stub

	}

	
	public void info(Marker marker, String message) {
		// TODO Auto-generated method stub

	}

	
	public void info(Marker marker, String message, Object... params) {
		// TODO Auto-generated method stub

	}

	
	public void info(Marker marker, String message, Throwable t) {
		// TODO Auto-generated method stub

	}

	
	public void info(Message msg) {
		String mess = "" + msg;
		config.getExtentTest().log(Status.INFO, mess);
		logger.info(msg);

	}

	
	public void info(Message msg, Throwable t) {
		// TODO Auto-generated method stub

	}

	
	public void info(Object message) {
		// TODO Auto-generated method stub

	}

	
	public void info(Object message, Throwable t) {
		// TODO Auto-generated method stub

	}

	
	public void info(String message) {
		config.getExtentTest().log(Status.INFO, message);	
		logger.info(message);
	}
	
	public void infoWithColor(String message, String color) {
		config.getExtentTest().log(Status.INFO, "<b><font color='"+color+"'>"+message+"</font></b>");	
		logger.info(message);
	}
	
	
	public void warn(String message) {
		config.getExtentTest().log(Status.WARNING, "<b><font color='orange'>"+message+"</font></b>");
		logger.warn(message);
	}

	
	public void info(String message, Object... params) {
		config.getExtentTest().log(Status.INFO, message);
		logger.info(message);

	}

	
	public void info(String message, Throwable t) {
		// TODO Auto-generated method stub

	}

	
	public boolean isDebugEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean isDebugEnabled(Marker marker) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean isEnabled(Level level) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean isEnabled(Level level, Marker marker) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean isErrorEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean isErrorEnabled(Marker marker) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean isFatalEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean isFatalEnabled(Marker marker) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean isInfoEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean isInfoEnabled(Marker marker) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean isTraceEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean isTraceEnabled(Marker marker) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean isWarnEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean isWarnEnabled(Marker marker) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public void log(Level level, Marker marker, Message msg) {
		// TODO Auto-generated method stub

	}

	
	public void log(Level level, Marker marker, Message msg, Throwable t) {
		// TODO Auto-generated method stub

	}

	
	public void log(Level level, Marker marker, Object message) {
		// TODO Auto-generated method stub

	}

	
	public void log(Level level, Marker marker, Object message, Throwable t) {
		// TODO Auto-generated method stub

	}

	
	public void log(Level level, Marker marker, String message) {
		// TODO Auto-generated method stub

	}

	
	public void log(Level level, Marker marker, String message, Object... params) {
		// TODO Auto-generated method stub

	}

	
	public void log(Level level, Marker marker, String message, Throwable t) {
		// TODO Auto-generated method stub

	}

	
	public void log(Level level, Message msg) {
		// TODO Auto-generated method stub

	}

	
	public void log(Level level, Message msg, Throwable t) {
		// TODO Auto-generated method stub

	}

	
	public void log(Level level, Object message) {
		// TODO Auto-generated method stub

	}

	
	public void log(Level level, Object message, Throwable t) {
		// TODO Auto-generated method stub

	}

	
	public void log(Level level, String message) {
		// TODO Auto-generated method stub

	}

	
	public void log(Level level, String message, Object... params) {
		// TODO Auto-generated method stub

	}

	
	public void log(Level level, String message, Throwable t) {
		// TODO Auto-generated method stub

	}

	
	public void printf(Level level, Marker marker, String format, Object... params) {
		// TODO Auto-generated method stub

	}

	
	public void printf(Level level, String format, Object... params) {
		// TODO Auto-generated method stub

	}

	
	public <T extends Throwable> T throwing(Level level, T t) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public <T extends Throwable> T throwing(T t) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void trace(Marker marker, Message msg) {
		// TODO Auto-generated method stub

	}

	
	public void trace(Marker marker, Message msg, Throwable t) {
		// TODO Auto-generated method stub

	}

	
	public void trace(Marker marker, Object message) {
		// TODO Auto-generated method stub

	}

	
	public void trace(Marker marker, Object message, Throwable t) {
		// TODO Auto-generated method stub

	}

	
	public void trace(Marker marker, String message) {
		// TODO Auto-generated method stub

	}

	
	public void trace(Marker marker, String message, Object... params) {
		// TODO Auto-generated method stub

	}

	
	public void trace(Marker marker, String message, Throwable t) {
		// TODO Auto-generated method stub

	}

	
	public void trace(Message msg) {
		// TODO Auto-generated method stub

	}

	
	public void trace(Message msg, Throwable t) {
		// TODO Auto-generated method stub

	}

	
	public void trace(Object message) {
		// TODO Auto-generated method stub

	}

	
	public void trace(Object message, Throwable t) {
		// TODO Auto-generated method stub

	}

	
	public void trace(String message) {
		// TODO Auto-generated method stub

	}

	
	public void trace(String message, Object... params) {
		// TODO Auto-generated method stub

	}

	
	public void trace(String message, Throwable t) {
		// TODO Auto-generated method stub

	}

	
	public void warn(Marker marker, Message msg) {
		// TODO Auto-generated method stub

	}

	
	public void warn(Marker marker, Message msg, Throwable t) {
		// TODO Auto-generated method stub

	}

	
	public void warn(Marker marker, Object message) {
		// TODO Auto-generated method stub

	}

	
	public void warn(Marker marker, Object message, Throwable t) {
		// TODO Auto-generated method stub

	}

	
	public void warn(Marker marker, String message) {
		// TODO Auto-generated method stub

	}

	
	public void warn(Marker marker, String message, Object... params) {
		// TODO Auto-generated method stub

	}

	
	public void warn(Marker marker, String message, Throwable t) {
		// TODO Auto-generated method stub

	}

	
	public void warn(Message msg) {
		// TODO Auto-generated method stub

	}

	
	public void warn(Message msg, Throwable t) {
		// TODO Auto-generated method stub

	}

	
	public void warn(Object message) {
		// TODO Auto-generated method stub

	}

	
	public void warn(Object message, Throwable t) {
		// TODO Auto-generated method stub

	}

	
	public void warn(String message, Object... params) {
		// TODO Auto-generated method stub

	}

	
	public void warn(String message, Throwable t) {
		// TODO Auto-generated method stub

	}


	
	public void debug(Supplier<?> arg0) {
		// TODO Auto-generated method stub
		
	}


	
	public void debug(Marker arg0, CharSequence arg1) {
		// TODO Auto-generated method stub
		
	}

	
	public void debug(Marker arg0, Supplier<?> arg1) {
		// TODO Auto-generated method stub
		
	}


	
	public void debug(CharSequence arg0, Throwable arg1) {
		// TODO Auto-generated method stub
		
	}

	
	public void debug(String arg0, Supplier<?>... arg1) {
		// TODO Auto-generated method stub
		
	}

	
	public void debug(Supplier<?> arg0, Throwable arg1) {
		// TODO Auto-generated method stub
		
	}

	
	public void debug(String arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}


	
	public void debug(Marker arg0, Supplier<?> arg1, Throwable arg2) {
		// TODO Auto-generated method stub
		
	}

	
	public void debug(Marker arg0, String arg1, Object arg2) {
		// TODO Auto-generated method stub
		
	}

	
	public void debug(String arg0, Object arg1, Object arg2) {
		// TODO Auto-generated method stub
		
	}

	
	public void debug(Marker arg0, String arg1, Object arg2, Object arg3) {
		// TODO Auto-generated method stub
		
	}

	
	public void debug(String arg0, Object arg1, Object arg2, Object arg3) {
		// TODO Auto-generated method stub
		
	}

	
	public void debug(Marker arg0, String arg1, Object arg2, Object arg3, Object arg4) {
		// TODO Auto-generated method stub
		
	}

	
	public void debug(String arg0, Object arg1, Object arg2, Object arg3, Object arg4) {
		// TODO Auto-generated method stub
		
	}

	
	public void debug(Marker arg0, String arg1, Object arg2, Object arg3, Object arg4, Object arg5) {
		// TODO Auto-generated method stub
		
	}

	
	public void debug(String arg0, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5) {
		// TODO Auto-generated method stub
		
	}

	
	public void debug(Marker arg0, String arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6) {
		// TODO Auto-generated method stub
		
	}

	
	public void debug(String arg0, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6) {
		// TODO Auto-generated method stub
		
	}

	
	public void debug(Marker arg0, String arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7) {
		// TODO Auto-generated method stub
		
	}

	
	public void debug(String arg0, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7) {
		// TODO Auto-generated method stub
		
	}

	
	public void debug(Marker arg0, String arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7, Object arg8) {
		// TODO Auto-generated method stub
		
	}


	public void debug(String message) {
		// TODO Auto-generated method stub
		
	}


	
}

