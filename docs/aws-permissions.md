AWS Permissions
---------------

AEM OpenCloud Manager build pipelines require the AWS permissions listed below.
The lists are separated by AEM OpenCloud libraries which are used by specific pipeline categories.

If your security design allows all pipelines to be run from a single role, you can add all permissions in one.
Otherwise, you can separate them in multiple roles as necessary.

Check out the [example CloudFormation template](https://github.com/shinesolutions/aem-opencloud-manager/blob/main/examples/aws-permissions.yaml) for provisioning these AWS permissions.

| Library | Pipeline Categories |
|---------|---------------------|
| Packer AEM | installation, machine-images |
| AEM AWS Stack Builder | installation, manage-environments, operational-tasks, testing |
| AEM Stack Manager Messenger | manage-environments, operational-tasks, testing |
| AEM Test Suite | testing |

## Packer AEM

- acm:GetCertificate
- ec2:AttachVolume
- ec2:AuthorizeSecurityGroupIngress
- ec2:CopyImage
- ec2:CreateImage
- ec2:CreateKeypair
- ec2:CreateSecurityGroup
- ec2:CreateSnapshot
- ec2:CreateTags
- ec2:CreateVolume
- ec2:DeleteKeypair
- ec2:DeleteSecurityGroup
- ec2:DeleteSnapshot
- ec2:DeleteVolume
- ec2:DeregisterImage
- ec2:DescribeImageAttribute
- ec2:DescribeImages
- ec2:DescribeInstances
- ec2:DescribeRegions
- ec2:DescribeSecurityGroups
- ec2:DescribeSnapshots
- ec2:DescribeSubnets
- ec2:DescribeTags
- ec2:DescribeVolumes
- ec2:DetachVolume
- ec2:GetPasswordData
- ec2:ModifyImageAttribute
- ec2:ModifyInstanceAttribute
- ec2:ModifySnapshotAttribute
- ec2:RegisterImage
- ec2:RunInstances
- ec2:StopInstances
- ec2:TerminateInstances
- iam:PassRole
- kms:Decrypt
- secretsmanager:GetSecretValue
- ssm:GetParameterHistory
- ssm:GetParametersByPath
- ssm:GetParameters
- ssm:GetParameter

## AEM AWS Stack Builder

- acm:*
- autoscaling:AttachInstances
- autoscaling:AttachLoadBalancerTargetGroups
- autoscaling:AttachLoadBalancers
- autoscaling:BatchDeleteScheduledAction
- autoscaling:BatchPutScheduledUpdateGroupAction
- autoscaling:CompleteLifecycleAction
- autoscaling:CreateAutoScalingGroup
- autoscaling:CreateLaunchConfiguration
- autoscaling:CreateOrUpdateTags
- autoscaling:DeleteAutoScalingGroup
- autoscaling:DeleteLaunchConfiguration
- autoscaling:DeleteLifecycleHook
- autoscaling:DeleteNotificationConfiguration
- autoscaling:DeleteScheduledAction
- autoscaling:DeleteTags
- autoscaling:DescribeAccountLimits
- autoscaling:DescribeAdjustmentTypes
- autoscaling:DescribeAutoScalingGroups
- autoscaling:DescribeAutoScalingInstances
- autoscaling:DescribeAutoScalingNotificationTypes
- autoscaling:DescribeLaunchConfigurations
- autoscaling:DescribeLifecycleHookTypes
- autoscaling:DescribeLifecycleHooks
- autoscaling:DescribeLoadBalancerTargetGroups
- autoscaling:DescribeLoadBalancers
- autoscaling:DescribeMetricCollectionTypes
- autoscaling:DescribeNotificationConfigurations
- autoscaling:DescribePolicies
- autoscaling:DescribeScalingActivities
- autoscaling:DescribeScalingProcessTypes
- autoscaling:DescribeScheduledActions
- autoscaling:DescribeTags
- autoscaling:DescribeTerminationPolicyTypes
- autoscaling:DetachInstances
- autoscaling:DetachLoadBalancerTargetGroups
- autoscaling:DetachLoadBalancers
- autoscaling:DisableMetricsCollection
- autoscaling:EnableMetricsCollection
- autoscaling:EnterStandby
- autoscaling:ExitStandby
- autoscaling:PutLifecycleHook
- autoscaling:PutNotificationConfiguration
- autoscaling:PutScalingPolicy
- autoscaling:PutScheduledUpdateGroupAction
- autoscaling:RecordLifecycleActionHeartbeat
- autoscaling:ResumeProcesses
- autoscaling:SetDesiredCapacity
- autoscaling:SetInstanceHealth
- autoscaling:SetInstanceProtection
- autoscaling:SuspendProcesses
- autoscaling:TerminateInstanceInAutoScalingGroup
- autoscaling:UpdateAutoScalingGroup
- cloudformation:CreateStack
- cloudformation:DeleteStack
- cloudformation:DescribeStackEvents
- cloudformation:DescribeStackResources
- cloudformation:DescribeStacks
- cloudformation:GetStackPolicy
- cloudformation:GetTemplate
- cloudformation:GetTemplateSummary
- cloudformation:ListStackResources
- cloudformation:ListStacks
- cloudformation:UpdateStack
- cloudwatch:DescribeAlarmHistory
- cloudwatch:DescribeAlarms
- cloudwatch:DescribeAlarmsForMetric
- cloudwatch:GetDashboard
- cloudwatch:GetMetricData
- cloudwatch:GetMetricStatistics
- cloudwatch:GetMetricWidgetImage
- cloudwatch:ListDashboards
- cloudwatch:ListMetrics
- cloudwatch:PutMetricAlarm
- cloudwatch:PutMetricData
- dynamodb:BatchGetItem
- dynamodb:ConditionCheckItem
- dynamodb:CreateTable
- dynamodb:DescribeBackup
- dynamodb:DescribeContinuousBackups
- dynamodb:DescribeGlobalTable
- dynamodb:DescribeGlobalTableSettings
- dynamodb:DescribeLimits
- dynamodb:DescribeReservedCapacity
- dynamodb:DescribeReservedCapacityOfferings
- dynamodb:DescribeStream
- dynamodb:DescribeTable
- dynamodb:DescribeTimeToLive
- dynamodb:GetItem
- dynamodb:GetRecords
- dynamodb:GetShardIterator
- dynamodb:ListBackups
- dynamodb:ListGlobalTables
- dynamodb:ListStreams
- dynamodb:ListTables
- dynamodb:ListTagsOfResource
- dynamodb:PutItem
- dynamodb:Query
- dynamodb:Scan
- dynamodb:UpdateItem
- dynamodb:UpdateTimeToLive
- ec2:AttachVolume
- ec2:AuthorizeSecurityGroupEgress
- ec2:AuthorizeSecurityGroupIngress
- ec2:CopyImage
- ec2:CreateImage
- ec2:CreateKeyPair
- ec2:CreateKeyPair
- ec2:CreateSecurityGroup
- ec2:CreateSnapshot
- ec2:CreateTags
- ec2:CreateVolume
- ec2:DeleteKeyPair
- ec2:DeleteKeyPair
- ec2:DeleteSecurityGroup
- ec2:DeleteSnapshot
- ec2:DeleteVolume
- ec2:DeregisterImage
- ec2:DescribeAccountAttributes
- ec2:DescribeAvailabilityZones
- ec2:DescribeImageAttribute
- ec2:DescribeImages
- ec2:DescribeInstances
- ec2:DescribeKeyPairs
- ec2:DescribeKeyPairs
- ec2:DescribeRegions
- ec2:DescribeSecurityGroupReferences
- ec2:DescribeSecurityGroups
- ec2:DescribeSnapshots
- ec2:DescribeSubnets
- ec2:DescribeTags
- ec2:DescribeVolumes
- ec2:DescribeVpcs
- ec2:DetachVolume
- ec2:GetPasswordData
- ec2:ImportKeyPair
- ec2:ModifyImageAttribute
- ec2:ModifyInstanceAttribute
- ec2:ModifySnapshotAttribute
- ec2:RegisterImage
- ec2:RevokeSecurityGroupEgress
- ec2:RevokeSecurityGroupIngress
- ec2:RunInstances
- ec2:StopInstances
- ec2:TerminateInstances
- elasticloadbalancing:*
- events:DescribeRule
- events:PutRule
- events:PutTargets
- iam:AddRoleToInstanceProfile
- iam:AttachRolePolicy
- iam:CreateInstanceProfile
- iam:CreatePolicy
- iam:CreateRole
- iam:CreateServiceLinkedRole
- iam:DetachRolePolicy
- iam:GetPolicy
- iam:GetRole
- iam:PassRole
- iam:PutRolePolicy
- iam:RemoveRoleFromInstanceProfile
- iam:UploadServerCertificate
- kms:Decrypt
- lambda:AddPermission
- lambda:CreateAlias
- lambda:CreateFunction
- lambda:GetFunction
- lambda:ListVersionsByFunction
- lambda:PublishVersion
- route53:ChangeResourceRecordSets
- route53:CreateHostedZone
- route53:DeleteHostedZone
- route53:GetChange
- route53:GetHostedZone
- route53:ListHostedZones
- route53:ListHostedZonesByName
- route53:ListResourceRecordSets
- s3:*
- secretsmanager:GetSecretValue
- sns:CreateTopic
- sns:GetTopicAttributes
- sns:ListTopics
- sns:Publish
- sns:SetTopicAttributes
- sns:Subscribe
- sqs:CreateQueue
- sqs:GetQueueAttributes
- sqs:ListQueues
- sqs:ReceiveMessage
- sqs:SetQueueAttributes
- ssm:CreateDocument
- ssm:DescribeDocument
- ssm:GetParameter
- ssm:GetParameterHistory
- ssm:GetParameters
- ssm:GetParametersByPath

## AEM Stack Manager Messenger

TODO

## AEM Test Suite

TODO
