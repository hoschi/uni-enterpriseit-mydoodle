
/**
 * PollserviceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.3  Built on : Nov 12, 2010 (02:24:07 CET)
 */

    package de.uniluebeck.itm.www;

    /**
     *  PollserviceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class PollserviceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public PollserviceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public PollserviceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for getPoll method
            * override this method for handling normal response from getPoll operation
            */
           public void receiveResultgetPoll(
                    de.uniluebeck.itm.www.PollserviceStub.GetPollResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getPoll operation
           */
            public void receiveErrorgetPoll(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getPolls method
            * override this method for handling normal response from getPolls operation
            */
           public void receiveResultgetPolls(
                    de.uniluebeck.itm.www.PollserviceStub.GetPollsResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getPolls operation
           */
            public void receiveErrorgetPolls(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for voteForOptions method
            * override this method for handling normal response from voteForOptions operation
            */
           public void receiveResultvoteForOptions(
                    de.uniluebeck.itm.www.PollserviceStub.VoteForOptionsResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from voteForOptions operation
           */
            public void receiveErrorvoteForOptions(java.lang.Exception e) {
            }
                


    }
    