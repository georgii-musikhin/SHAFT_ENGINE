package com.shaft.properties.internal;

import com.shaft.tools.io.ReportManager;
import org.aeonbits.owner.Config.Sources;
import org.aeonbits.owner.ConfigFactory;

@SuppressWarnings("unused")
@Sources({"system:properties", "file:src/main/resources/properties/Reporting.properties", "file:src/main/resources/properties/default/Reporting.properties", "classpath:Reporting.properties"})
public interface Reporting extends EngineProperties {
    private static void setProperty(String key, String value) {
        var updatedProps = new java.util.Properties();
        updatedProps.setProperty(key, value);
        Properties.reporting = ConfigFactory.create(Reporting.class, updatedProps);
        // temporarily set the system property to support hybrid read/write mode
        System.setProperty(key, value);
        if (!key.equals("disableLogging"))
            ReportManager.logDiscrete("Setting \"" + key + "\" property with \"" + value + "\".");
    }

    @Key("captureElementName")
    @DefaultValue("true")
    boolean captureElementName();

    @Key("captureWebDriverLogs")
    @DefaultValue("false")
    boolean captureWebDriverLogs();

    @Key("alwaysLogDiscreetly")
    @DefaultValue("false")
    boolean alwaysLogDiscreetly();

    @Key("debugMode")
    @DefaultValue("false")
    boolean debugMode();

    @Key("cleanAllureResultsDirectoryBeforeExecution")
    @DefaultValue("true")
    boolean cleanAllureResultsDirectoryBeforeExecution();

    @Key("generateAllureReportArchive")
    @DefaultValue("false")
    boolean generateAllureReportArchive();

    @Key("openAllureReportAfterExecution")
    @DefaultValue("false")
    boolean openAllureReportAfterExecution();

    @Key("generateExtentReports")
    @DefaultValue("true")
    boolean generateExtentReports();

    @Key("cleanExtentReportsDirectoryBeforeExecution")
    @DefaultValue("true")
    boolean cleanExtentReportsDirectoryBeforeExecution();

    @Key("attachExtentReportsToAllureReport")
    @DefaultValue("false")
    boolean attachExtentReportsToAllureReport();

    @Key("openLighthouseReportWhileExecution")
    @DefaultValue("false")
    boolean openLighthouseReportWhileExecution();

    @Key("cleanSummaryReportsDirectoryBeforeExecution")
    @DefaultValue("true")
    boolean cleanSummaryReportsDirectoryBeforeExecution();

    @Key("openExecutionSummaryReportAfterExecution")
    @DefaultValue("true")
    boolean openExecutionSummaryReportAfterExecution();

    @Key("openExtentReportAfterExecution")
    @DefaultValue("false")
    boolean openExtentReportAfterExecution();

    @Key("disableLogging")
    @DefaultValue("true")
    boolean disableLogging();
    
    default SetProperty set() {
        return new SetProperty();
    }

    class SetProperty implements EngineProperties.SetProperty {

        public SetProperty captureElementName(boolean value) {
            setProperty("captureElementName", String.valueOf(value));
            return this;
        }

        public SetProperty forceCheckForElementVisibility(boolean value) {
            setProperty("forceCheckForElementVisibility", String.valueOf(value));
            return this;
        }

        public SetProperty captureWebDriverLogs(boolean value) {
            setProperty("captureWebDriverLogs", String.valueOf(value));
            return this;
        }

        public SetProperty alwaysLogDiscreetly(boolean value) {
            setProperty("alwaysLogDiscreetly", String.valueOf(value));
            return this;
        }

        public SetProperty debugMode(boolean value) {
            setProperty("debugMode", String.valueOf(value));
            return this;
        }

        public SetProperty cleanAllureResultsDirectoryBeforeExecution(boolean value) {
            setProperty("cleanAllureResultsDirectoryBeforeExecution", String.valueOf(value));
            return this;
        }

        public SetProperty cleanSummaryReportsDirectoryBeforeExecution(boolean value) {
            setProperty("cleanSummaryReportsDirectoryBeforeExecution", String.valueOf(value));
            return this;
        }

        public SetProperty generateAllureReportArchive(boolean value) {
            setProperty("generateAllureReportArchive", String.valueOf(value));
            return this;
        }

        public SetProperty openAllureReportAfterExecution(boolean value) {
            setProperty("openAllureReportAfterExecution", String.valueOf(value));
            return this;
        }

        public SetProperty generateExtentReports(boolean value) {
            setProperty("generateExtentReports", String.valueOf(value));
            return this;
        }

        public SetProperty cleanExtentReportsDirectoryBeforeExecution(boolean value) {
            setProperty("cleanExtentReportsDirectoryBeforeExecution", String.valueOf(value));
            return this;
        }

        public SetProperty attachExtentReportsToAllureReport(boolean value) {
            setProperty("attachExtentReportsToAllureReport", String.valueOf(value));
            return this;
        }

        public SetProperty openLighthouseReportWhileExecution(boolean value) {
            setProperty("openLighthouseReportWhileExecution", String.valueOf(value));
            return this;
        }

        public SetProperty openExecutionSummaryReportAfterExecution(boolean value) {
            setProperty("openExecutionSummaryReportAfterExecution", String.valueOf(value));
            return this;
        }

        public SetProperty openExtentReportAfterExecution(boolean value) {
            setProperty("openExtentReportAfterExecution", String.valueOf(value));
            return this;
        }

        public SetProperty disableLogging(boolean value) {
            setProperty("disableLogging", String.valueOf(value));
            return this;
        }

    }

}
