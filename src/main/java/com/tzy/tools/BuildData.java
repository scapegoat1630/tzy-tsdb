package com.tzy.tools;

public final class BuildData {
    /**
     * Version string MAJOR.MINOR.MAINT
     */
    public static final String version = "BuildData";
    /**
     * Short revision at which this package was built.
     */
    public static final String short_revision = "cac608a";
    /**
     * Full revision at which this package was built.
     */
    public static final String full_revision = "cac608ad7bfaf6315fd2319a8af37da307abdeb9";
    /**
     * UTC date at which this package was built.
     */
    public static final String date = "2017/01/15 01:48:29 +0000";
    /**
     * UNIX timestamp of the time of the build.
     */
    public static final long timestamp = 1484444909;

    /**
     * Represents the status of the repository at the time of the build.
     */
    public static enum RepoStatus {
        /**
         * The status of the repository was unknown at the time of the build.
         */
        UNKNOWN,
        /**
         * There was no local modification during the build.
         */
        MINT,
        /**
         * There were some local modifications during the build.
         */
        MODIFIED;
    }

    /**
     * Status of the repository at the time of the build.
     */
    public static final RepoStatus repo_status = RepoStatus.MINT;

    /**
     * Username of the user who built this package.
     */
    public static final String user = "clarsen";
    /**
     * Host on which this package was built.
     */
    public static final String host = "racesucceed-lm";
    /**
     * Path to the repository in which this package was built.
     */
    public static final String repo = "/Users/clarsen/Documents/opentsdb/opentsdb_OFFICIAL";
    /**
     * Git branch
     */
    public static final String branch = "master";

    /**
     * Human readable string describing the revision of this package.
     */
    public static final String revisionString() {
        return "net.opentsdb.tools BuildData built at revision cac608a (MINT)";
    }

    /**
     * Human readable string describing the build information of this package.
     */
    public static final String buildString() {
        return "Built on 2017/01/15 01:48:29 +0000 by clarsen@racesucceed-lm:/Users/clarsen/Documents/opentsdb/opentsdb_OFFICIAL";
    }

    // These functions are useful to avoid cross-jar inlining.

    /**
     * Version string MAJOR.MINOR.MAINT
     */
    public static String version() {
        return version;
    }

    /**
     * Short revision at which this package was built.
     */
    public static String shortRevision() {
        return short_revision;
    }

    /**
     * Full revision at which this package was built.
     */
    public static String fullRevision() {
        return full_revision;
    }

    /**
     * UTC date at which this package was built.
     */
    public static String date() {
        return date;
    }

    /**
     * UNIX timestamp of the time of the build.
     */
    public static long timestamp() {
        return timestamp;
    }

    /**
     * Status of the repository at the time of the build.
     */
    public static RepoStatus repoStatus() {
        return repo_status;
    }

    /**
     * Username of the user who built this package.
     */
    public static String user() {
        return user;
    }

    /**
     * Host on which this package was built.
     */
    public static String host() {
        return host;
    }

    /**
     * Path to the repository in which this package was built.
     */
    public static String repo() {
        return repo;
    }

    // Can't instantiate.
    private BuildData() {
    }

    public static void main(String[] args) {
        System.out.println(revisionString());
        System.out.println(buildString());
    }
}