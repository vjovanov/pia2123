<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : LabReservationPage
    Created on : 24.09.2009., 18.57.09
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
                        <webuijsf:table augmentTitle="false" id="table1" title="Table" >
                            <webuijsf:tableRowGroup id="tableRowGroup1" rows="14" sourceData="#{labmanager.labSchedule.schedule}" sourceVar="lab">
                                <webuijsf:tableColumn headerText="Nedelja" id="tableColumn1" >
                                    <webuijsf:staticText id="staticText1" text="#{lab.value.Sunday}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn headerText="Ponedeljak" id="tableColumn2" >
                                    <webuijsf:staticText id="staticText2" text="#{lab.value.Monday}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn headerText="Utorak" id="tableColumn3" >
                                    <webuijsf:staticText id="staticText3" text="#{lab.value.Tuesday}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn headerText="Sreda" id="tableColumn4" >
                                    <webuijsf:staticText id="staticText4" text="#{lab.value.Wednesday}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn headerText="Cetvrtak" id="tableColumn5" >
                                    <webuijsf:staticText id="staticText5" text="#{lab.value.Thursday}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn headerText="Petak" id="tableColumn6" >
                                    <webuijsf:staticText id="staticText6" text="#{lab.value.Friday}"/>
                                </webuijsf:tableColumn>
                                <webuijsf:tableColumn headerText="Subota" id="tableColumn7" >
                                    <webuijsf:staticText id="staticText7" text="#{lab.value.Saturday}"/>
                                </webuijsf:tableColumn>
                            </webuijsf:tableRowGroup>
                        </webuijsf:table><br/>
                        
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
