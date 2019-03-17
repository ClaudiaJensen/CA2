/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

import javax.ws.rs.WebApplicationException;

/**
 *
 * @author claudia
 */
public class MyException extends WebApplicationException
{

    public MyException(String message)
    {
        super(message);
    }
}
