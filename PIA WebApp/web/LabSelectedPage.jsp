<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : LabSelectedPage
    Created on : 24.09.2009., 01.47.05
    Author     : Administrator
-->

<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page id="page1">
            <webuijsf:html id="html1">
                <webuijsf:head id="head1">
                    <webuijsf:link id="link1" url="/resources/stylesheet.css"/>
                </webuijsf:head>
                <webuijsf:body id="body1" style="-rave-layout: grid">
                    <DIV ALIGN="Center">
                    <webuijsf:form id="form1">
                        <h3><h:outputText value="#{labmanager.selected}" style="font-size: 23pt"/></h3>
                        <br/>
                        <table width="30%" border="3">
                        <tr><td> Lokacija</td>
                        <td><h:outputText value="#{labmanager.lab.location}" style="font-size: 15pt"/> </td></tr>
                        <tr><td>Kapacitet:</td>
                        <td><h:outputText value="#{labmanager.lab.capacity}" style="font-size: 15pt"/></td></tr>
                        <tr><td>Broj racunara:</td>
                        <td><h:outputText value="#{labmanager.lab.pcNumber}" style="font-size: 15pt"/></td></tr>
                        <tr><td>Da li ima tablu:</td>
                        <td><h:outputText value="#{labmanager.lab.hasBlackboard}" style="font-size: 15pt"/></td></tr>
                        <tr><td>Da li ima projektor:</td>
                        <td><h:outputText value="#{labmanager.lab.hasProjector}" style="font-size: 15pt"/></td></tr>
                        </table><br/><br/>
                        <webuijsf:calendar id="calendar" selectedDate="#{labmanager.selectedDate}" minDate="#{labmanager.dateNow}" required="true" style="font-size: 15pt" />
                        <br/>
                        <webuijsf:button actionExpression="#{labmanager.laboratoryReservation}" id="button2" text="Rezrvacija laboratorije" style = "font-size: 15pt"/>                        
                    </webuijsf:form>
                    <webuijsf:form id="form2">
                            <webuijsf:button actionExpression="#{gotopage.back}" id="button2" text="Nazad" style = "font-size: 15pt"/>
                    </webuijsf:form>
                    </DIV>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
