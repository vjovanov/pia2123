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
                        
                        <h3><h:outputText value="#{manageUser.selected}" style="font-size: 23pt"/></h3>
                        <br/>
                        <webuijsf:textField id="textfield1" label="Lokacija:" required="true" style="font-size: 15pt" text="#{manageUser.lab.location}"/><br/>
                        <webuijsf:textField id="textfield2" label="Kapacitet:" required="true" style="font-size: 15pt" text="#{manageUser.lab.capacity}"/><br/>
                        <webuijsf:textField id="textfield3" label="Broj racunara:" required="true" style="font-size: 15pt" text="#{manageUser.lab.pcNumber}"/><br/>
                        <webuijsf:textField id="textfield4" label="Ima li tablu:" required="true" style="font-size: 15pt" text="#{manageUser.lab.hasBlackboard}"/><br/>
                        <webuijsf:textField id="textfield5" label="Ima li projektor:" required="true" style="font-size: 15pt" text="#{manageUser.lab.hasProjector}"/><br/>
                        
                        <webuijsf:button actionExpression="#{manageUser.editLab}" id="button2" text="Izmena podataka laboratorije" style = "font-size: 15pt"/>
                        
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
