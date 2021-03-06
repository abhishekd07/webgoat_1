package org.owasp.webgoat.lessons;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*******************************************************************************
 * 
 * 
 * This file is part of WebGoat, an Open Web Application Security Project
 * utility. For details, please see http://www.owasp.org/
 * 
 * Copyright (c) 2002 - 2007 Bruce Mayhew
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 59 Temple
 * Place - Suite 330, Boston, MA 02111-1307, USA.
 * 
 * Getting Source ==============
 * 
 * Source for this application is maintained at code.google.com, a repository
 * for free software projects.
 * 
 * For details, please see http://code.google.com/p/webgoat/
 * 
 * @author Bruce Mayhew <a href="http://code.google.com/p/webgoat">WebGoat</a>
 * @created October 28, 2003
 */
public class Category implements Comparable
{

	public final static Category UNVALIDATED_PARAMETERS = new Category("Unvalidated Parameters", new Integer(110));

	public final static Category ACCESS_CONTROL = new Category("Access Control Flaws", new Integer(210));

	public final static Category AUTHENTICATION = new Category("Authentication Flaws", new Integer(310));

	public final static Category SESSION_MANAGEMENT = new Category("Session Management Flaws", new Integer(320));

	public final static Category XSS = new Category("Cross-Site Scripting (XSS)", new Integer(410));

	public final static Category BUFFER_OVERFLOW = new Category("Buffer Overflows", new Integer(510));

	public final static Category INJECTION = new Category("Injection Flaws", new Integer(610));

	public final static Category ERROR_HANDLING = new Category("Improper Error Handling", new Integer(710));

	public final static Category INSECURE_STORAGE = new Category("Insecure Storage", new Integer(810));

	public final static Category DOS = new Category("Denial of Service", new Integer(910));

	public final static Category INSECURE_CONFIGURATION = new Category("Insecure Configuration", new Integer(1010));

	public final static Category WEB_SERVICES = new Category("Web Services", new Integer(1110));

	public final static Category AJAX_SECURITY = new Category("AJAX Security", new Integer(1150));

	public final static Category ADMIN_FUNCTIONS = new Category("Admin Functions", new Integer(10));

	public final static Category GENERAL = new Category("General", new Integer(50));

	public final static Category CODE_QUALITY = new Category("Code Quality", new Integer(70));

	public final static Category CONCURRENCY = new Category("Concurrency", new Integer(80));

	public final static Category CHALLENGE = new Category("Challenge", new Integer(2000));

	private static final List<Category> categories = new ArrayList<Category>();

	private String category;

	private Integer ranking;

	static
	{
		categories.add(UNVALIDATED_PARAMETERS);
		categories.add(ACCESS_CONTROL);
		categories.add(AUTHENTICATION);
		categories.add(SESSION_MANAGEMENT);
		categories.add(XSS);
		categories.add(BUFFER_OVERFLOW);
		categories.add(INJECTION);
		categories.add(ERROR_HANDLING);
		categories.add(INSECURE_STORAGE);
		categories.add(DOS);
		categories.add(INSECURE_CONFIGURATION);
		categories.add(WEB_SERVICES);
		categories.add(AJAX_SECURITY);
		categories.add(ADMIN_FUNCTIONS);
		categories.add(GENERAL);
		categories.add(CODE_QUALITY);
		categories.add(CONCURRENCY);
		categories.add(CHALLENGE);
	}

	public static synchronized void addCategory(Category c)
	{
		categories.add(c);
	}

	public static synchronized Category getCategory(String name)
	{
		Iterator<Category> it = categories.iterator();
		while (it.hasNext())
		{
			Category c = it.next();
			if (c.getName().equals(name)) return c;
		}
		return null;
	}

	public Category(String category, Integer ranking)
	{
		this.category = category;
		this.ranking = ranking;
	}

	public int compareTo(Object obj)
	{
		int value = 1;

		if (obj instanceof Category)
		{
			value = this.getRanking().compareTo(((Category) obj).getRanking());
		}

		return value;
	}

	public Integer getRanking()
	{
		return ranking;
	}

	public Integer setRanking(Integer ranking)
	{
		return this.ranking = ranking;
	}

	public String getName()
	{
		return category;
	}

	public boolean equals(Object obj)
	{
		return (obj instanceof Category) && getName().equals(((Category) obj).getName());
	}

	public String toString()
	{
		return getName();
	}
}