package org.cgi.devops.devopsrest.services;

//import org.apache.http.auth.UsernamePasswordCredentials;
import org.cgi.devops.devopsrest.model.BambooSpecs;
import org.springframework.stereotype.Service;

import com.atlassian.bamboo.specs.api.builders.applink.ApplicationLink;
import com.atlassian.bamboo.specs.api.builders.permission.PermissionType;
import com.atlassian.bamboo.specs.api.builders.permission.Permissions;
import com.atlassian.bamboo.specs.api.builders.permission.PlanPermissions;
import com.atlassian.bamboo.specs.api.builders.plan.Job;
import com.atlassian.bamboo.specs.api.builders.plan.Plan;
import com.atlassian.bamboo.specs.api.builders.plan.PlanIdentifier;
import com.atlassian.bamboo.specs.api.builders.plan.Stage;
import com.atlassian.bamboo.specs.api.builders.project.Project;
import com.atlassian.bamboo.specs.builders.repository.bitbucket.server.BitbucketServerRepository;
import com.atlassian.bamboo.specs.builders.task.CheckoutItem;
import com.atlassian.bamboo.specs.builders.task.DockerBuildImageTask;
import com.atlassian.bamboo.specs.builders.task.DockerRunContainerTask;
import com.atlassian.bamboo.specs.builders.task.MavenTask;
import com.atlassian.bamboo.specs.builders.task.ScriptTask;
import com.atlassian.bamboo.specs.builders.task.VcsCheckoutTask;
import com.atlassian.bamboo.specs.builders.trigger.RemoteTrigger;
import com.atlassian.bamboo.specs.util.BambooServer;
import com.atlassian.bamboo.specs.util.UserPasswordCredentials;

//import com.atlassian.bamboo.specs.util.UserPasswordCredentials;

@Service
public class BambooService {

	public void bambooTrigger(BambooSpecs bambooSpecs) {
		// BambooServer bambooServer = new
		// BambooServer(bambooSpecs.getBambooServerUrl(),(UserPasswordCredentials)
		// new UsernamePasswordCredentials(bambooSpecs.getBambooUsername(),
		// bambooSpecs.getBambooPassword()));

		BambooServer bambooServer = new BambooServer(bambooSpecs.getBambooServerUrl(), new UserPasswordCredentials() {

			@Override
			public String getUsername() {
				return bambooSpecs.getBambooUsername();
			}

			@Override
			public String getPassword() {
				return bambooSpecs.getBambooPassword();
			}
		});
		
		Plan plan;
		
		if (bambooSpecs.getDockerContainerName().equals("docker-compose")) {
            plan = new BambooService().createPlanWithDockerCompose(bambooSpecs);
        } else {
            plan = new BambooService().createPlan(bambooSpecs);
        }
		

		bambooServer.publish(plan);

		PlanPermissions planPermission = new BambooService().createPlanPermission(plan.getIdentifier());

		bambooServer.publish(planPermission);
	}

	public PlanPermissions createPlanPermission(PlanIdentifier planIdentifier) {
		Permissions permission = new Permissions()
				.userPermissions("devopsadmin", PermissionType.ADMIN, PermissionType.CLONE, PermissionType.EDIT)
				.groupPermissions("bamboo-admin", PermissionType.ADMIN).loggedInUserPermissions(PermissionType.ADMIN)
				.anonymousUserPermissionView();
		return new PlanPermissions(planIdentifier.getProjectKey(), planIdentifier.getPlanKey()).permissions(permission);
	}

	public Project project(BambooSpecs bambooSpecs) {
		return new Project().name(bambooSpecs.getBambooProjectName()).key(bambooSpecs.getBambooProjectKey());
	}

	public Plan createPlan(BambooSpecs bambooSpecs) {
		ApplicationLink serverB = new ApplicationLink();
		serverB.id("583ebe30-b71f-3403-b0d0-1a93c8d6fa69");
		serverB.name("Bitbucket");
		// BitbucketServerRepository repositories = new
		// BitbucketServerRepository().server(server);
		return new Plan(project(bambooSpecs), bambooSpecs.getBambooPlanName(), bambooSpecs.getBambooPlanKey())
				.planRepositories(new BitbucketServerRepository().name(bambooSpecs.getBitbucketRepoName())
						.server(serverB).projectKey(bambooSpecs.getBitbucketProjectKey())
						.repositorySlug(bambooSpecs.getBitbucketRepoSlug())
						.branch(bambooSpecs.getBitbucketRepoBranch()))
				.description("Plan created from (my desc)").enabled(true)
				.stages(new Stage("my first stage")
						.jobs(new Job(bambooSpecs.getBambooJobName(), bambooSpecs.getBambooJobKey()).tasks(
								new VcsCheckoutTask().cleanCheckout(false).checkoutItems(
										new CheckoutItem().defaultRepository(),
										new CheckoutItem().repository(bambooSpecs.getBitbucketRepoName())
												.path("../../../../Devd/")),
								new MavenTask().goal("package -DskipTests=true").hasTests(false).version3()
										.jdk("JDK 1.8").executableLabel("Maven 3"),
								new DockerBuildImageTask().imageName(bambooSpecs.getDockerImageName())
										.dockerfileInWorkingDir(),
								new DockerRunContainerTask().imageName(bambooSpecs.getDockerImageName())
										.additionalArguments("-d -p " + bambooSpecs.getDockerHostPort() + ":"
												+ bambooSpecs.getDockerContainerPort() + " --name="
												+ bambooSpecs.getDockerContainerName())
										.containerEnvironmentVariables(
												"ENV1=devendra ENV3=sankho ENV4=sankho ENV2=sankho mahi=mahesh WORDPRESS_DB_HOSTURL=gotyaa WORDPRESS_DB_=praneeth"),
								new ScriptTask().inlineBody("docker ps -a"))))
				.triggers(new RemoteTrigger());
	}
	
	public Plan createPlanWithDockerCompose(BambooSpecs bambooSpecs) {
		ApplicationLink serverB = new ApplicationLink();
		serverB.id("583ebe30-b71f-3403-b0d0-1a93c8d6fa69");
		serverB.name("Bitbucket");
		// BitbucketServerRepository repositories = new
		// BitbucketServerRepository().server(server);
		return new Plan(project(bambooSpecs), bambooSpecs.getBambooPlanName(), bambooSpecs.getBambooPlanKey())
				.planRepositories(new BitbucketServerRepository().name(bambooSpecs.getBitbucketRepoName())
						.server(serverB).projectKey(bambooSpecs.getBitbucketProjectKey())
						.repositorySlug(bambooSpecs.getBitbucketRepoSlug())
						.branch(bambooSpecs.getBitbucketRepoBranch()))
				.description("Plan created from (my desc)").enabled(true)
				.stages(new Stage("my first stage")
						.jobs(new Job(bambooSpecs.getBambooJobName(), bambooSpecs.getBambooJobKey()).tasks(
								new VcsCheckoutTask().cleanCheckout(false).checkoutItems(
										new CheckoutItem().defaultRepository(),
										new CheckoutItem().repository(bambooSpecs.getBitbucketRepoName())
												.path("../../../../Devd/")),
								new MavenTask().goal("package -DskipTests=true").hasTests(false).version3()
										.jdk("JDK 1.8").executableLabel("Maven 3"),
								new ScriptTask().inlineBody("docker-compose -f docker-compose.yml up -d"))))
				.triggers(new RemoteTrigger());
	}

}
