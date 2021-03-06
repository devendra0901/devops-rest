package org.cgi.devops.devopsrest.model;

/*  
 * Model For Bamboo Specifications
 * 
 *  */

public class BambooSpecs {

	private String bambooServerUrl;

	private String bambooUsername;

	private String bambooPassword;

	private String bambooProjectName;

	private String bambooProjectKey;

	private String bambooPlanName;

	private String bambooPlanKey;

	private String bambooJobName;

	private String bambooJobKey;

	private String bitbucketProjectKey;

	private String bitbucketRepoName;

	private String bitbucketRepoSlug;

	private String bitbucketRepoBranch;

	private String dockerImageName;

	private String dockerContainerName;

	private String dockerHostPort;

	private String dockerContainerPort;

	private String dockerConfig;

	public String getDockerConfig() {
		return dockerConfig;
	}

	public void setDockerConfig(String dockerConfig) {
		this.dockerConfig = dockerConfig;
	}

	public String getDockerImageName() {
		return dockerImageName;
	}

	public void setDockerImageName(String dockerImageName) {
		this.dockerImageName = dockerImageName;
	}

	public String getDockerContainerName() {
		return dockerContainerName;
	}

	public void setDockerContainerName(String dockerContainerName) {
		this.dockerContainerName = dockerContainerName;
	}

	public String getDockerHostPort() {
		return dockerHostPort;
	}

	public void setDockerHostPort(String dockerHostPort) {
		this.dockerHostPort = dockerHostPort;
	}

	public String getDockerContainerPort() {
		return dockerContainerPort;
	}

	public void setDockerContainerPort(String dockerContainerPort) {
		this.dockerContainerPort = dockerContainerPort;
	}

	public String getBitbucketProjectKey() {
		return bitbucketProjectKey;
	}

	public void setBitbucketProjectKey(String bitbucketProjectKey) {
		this.bitbucketProjectKey = bitbucketProjectKey;
	}

	public String getBitbucketRepoName() {
		return bitbucketRepoName;
	}

	public void setBitbucketRepoName(String bitbucketRepoName) {
		this.bitbucketRepoName = bitbucketRepoName;
	}

	public String getBitbucketRepoSlug() {
		return bitbucketRepoSlug;
	}

	public void setBitbucketRepoSlug(String bitbucketRepoSlug) {
		this.bitbucketRepoSlug = bitbucketRepoSlug;
	}

	public String getBitbucketRepoBranch() {
		return bitbucketRepoBranch;
	}

	public void setBitbucketRepoBranch(String bitbucketRepoBranch) {
		this.bitbucketRepoBranch = bitbucketRepoBranch;
	}

	public String getBambooServerUrl() {
		return bambooServerUrl;
	}

	public void setBambooServerUrl(String bambooServerUrl) {
		this.bambooServerUrl = bambooServerUrl;
	}

	public String getBambooUsername() {
		return bambooUsername;
	}

	public void setBambooUsername(String bambooUsername) {
		this.bambooUsername = bambooUsername;
	}

	public String getBambooPassword() {
		return bambooPassword;
	}

	public void setBambooPassword(String bambooPassword) {
		this.bambooPassword = bambooPassword;
	}

	public String getBambooProjectName() {
		return bambooProjectName;
	}

	public void setBambooProjectName(String bambooProjectName) {
		this.bambooProjectName = bambooProjectName;
	}

	public String getBambooProjectKey() {
		return bambooProjectKey;
	}

	public void setBambooProjectKey(String bambooProjectKey) {
		this.bambooProjectKey = bambooProjectKey;
	}

	public String getBambooPlanName() {
		return bambooPlanName;
	}

	public void setBambooPlanName(String bambooPlanName) {
		this.bambooPlanName = bambooPlanName;
	}

	public String getBambooPlanKey() {
		return bambooPlanKey;
	}

	public void setBambooPlanKey(String bambooPlanKey) {
		this.bambooPlanKey = bambooPlanKey;
	}

	public String getBambooJobName() {
		return bambooJobName;
	}

	public void setBambooJobName(String bambooJobName) {
		this.bambooJobName = bambooJobName;
	}

	public String getBambooJobKey() {
		return bambooJobKey;
	}

	public void setBambooJobKey(String bambooJobKey) {
		this.bambooJobKey = bambooJobKey;
	}

	public BambooSpecs() {

	}

	public BambooSpecs(String bambooServerUrl, String bambooUsername, String bambooPassword, String bambooProjectName,
			String bambooProjectKey, String bambooPlanName, String bambooPlanKey, String bambooJobName,
			String bambooJobKey, String bitbucketProjectKey, String bitbucketRepoName, String bitbucketRepoSlug,
			String bitbucketRepoBranch, String dockerImageName, String dockerContainerName, String dockerHostPort,
			String dockerContainerPort, String dockerConfig) {
		super();
		this.bambooServerUrl = bambooServerUrl;
		this.bambooUsername = bambooUsername;
		this.bambooPassword = bambooPassword;
		this.bambooProjectName = bambooProjectName;
		this.bambooProjectKey = bambooProjectKey;
		this.bambooPlanName = bambooPlanName;
		this.bambooPlanKey = bambooPlanKey;
		this.bambooJobName = bambooJobName;
		this.bambooJobKey = bambooJobKey;
		this.bitbucketProjectKey = bitbucketProjectKey;
		this.bitbucketRepoName = bitbucketRepoName;
		this.bitbucketRepoSlug = bitbucketRepoSlug;
		this.bitbucketRepoBranch = bitbucketRepoBranch;
		this.dockerImageName = dockerImageName;
		this.dockerContainerName = dockerContainerName;
		this.dockerHostPort = dockerHostPort;
		this.dockerContainerPort = dockerContainerPort;
		this.dockerConfig = dockerConfig;
	}

}
