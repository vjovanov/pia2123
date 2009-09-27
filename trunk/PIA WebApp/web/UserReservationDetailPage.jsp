<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : AdminrReservationPage
    Created on : 27.09.2009., 12.50.22
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
                        <h:outputText value="Izaberi laboratoriju" style="font-size: 15pt"/><br/>
                        <webuijsf:listbox selected="#{user.selectedRes}" id="listbox1" items="#{user.lista}" style="font-size: 15pt" /><br/>
                        <h:outputText value="Izaberi datum rezervacije" style="font-size: 15pt"/><br/>
                        <webuijsf:calendar id="calendar" selectedDate="#{user.selectedDate}" minDate="#{user.dateNow}" required="true" style="font-size: 15pt" /><br/>
                        <webuijsf:textField id="text1" label="Unesi namenu rezervacije       " required="true" style="font-size: 15pt" text="#{user.reservation.namena}"/><br/>
                        <webuijsf:textField id="text2" label="Unesi sat pocetka              " required="true" style="font-size: 15pt" text="#{user.reservation.pocevOd}"/><br/>
                        <webuijsf:textField id="text3" label="Unesi trajanje zeljenog termina" required="true" style="font-size: 15pt" text="#{user.reservation.trajanje}"/><br/>
                        <webuijsf:button actionExpression="#{user.tryReservation}" id="button2" text="Rezervisi!" style = "font-size: 15pt"/>
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
