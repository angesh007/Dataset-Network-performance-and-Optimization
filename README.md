A computer network's Quality of Service (QoS) is referred to as network performance. It includes a number of
factors, including data transfer speed, availability, dependability, and scalability. On the other side, network
optimization describes the process of enhancing network performance by locating and fixing network problems,
upgrading network protocols, and lowering latency and congestion.
Various methods, including network traffic analysis, capacity planning, network configuration management,
and network monitoring, can be used to improve network performance. Typical methods for network
optimisation include:
1. Bandwidth optimization: This involves optimizing the utilization of network bandwidth by prioritizing
network traffic and reducing unnecessary traffic.
2. Latency reduction: This involves reducing the delay or latency in network communication by optimizing
network protocols and reducing network congestion.
3. Network security optimization: This involves implementing security measures to protect the network from
external threats such as malware, viruses, and hackers.
4. Network topology optimization: This involves optimizing the network topology to improve network
performance by reducing the number of network hops, minimizing network latency, and improving network
reliability.
5. Network protocol optimization: This involves optimizing network protocols to reduce network overhead and
improve network performance.
Overall, network performance and optimization are crucial for ensuring smooth and efficient network
operations, reducing downtime, and improving user experience.
Data gathering is a crucial component of network performance and optimization since it offers important
insights into how the network is operating, what problems are there, and how to fix them. Tools for monitoring
network performance can be used to gather information on a variety of performance metrics, including network
traffic, bandwidth use, latency, packet loss, and network faults.
The information gathered can be used to locate network problems, monitor network usage patterns, and
examine long-term trends in network performance. By finding potential improvement areas, putting new
network improvements into place, and evaluating their effects, this knowledge may subsequently be used to
optimize network performance.
Data collection, for instance, can assist in identifying which devices or apps are consuming the most bandwidth
and helping them prioritize their traffic if network traffic is found to be a bottleneck. Data gathering can help
determine which network protocols are causing the delay if network latency is a problem, and those protocols
can then be optimized accordingly.
Data collection can assist in capacity planning by recognizing trends in network usage and forecasting
upcoming network requirements. Network administrators may use this to prepare for future development and
make sure the network infrastructure is optimized to match the organization's evolving demands.
In general, data collection is a key tool for network performance and optimization, offering insightful
information on network performance, spotting problems, and directing network optimization efforts.
The given data set appears to be a collection of flow-level network traffic features. Each row in the data set
represents a network flow, which is a unidirectional sequence of packets between a source and destination IP
address and port combination, captured at a specific timestamp. The data set includes various features related to
the characteristics of these flows, such as flow duration, packet counts, packet lengths, inter-arrival times, flag
counts, window size, segment sizes, and other statistical measures.
The data set contains a wide range of features that provide information about both the forward (source to
destination) and backward (destination to source) traffic flows. These features include descriptive statistics such
as maximum, minimum, mean, and standard deviation of packet lengths, inter-arrival times, and other flow
properties. Additionally, there are features related to the presence of specific flags in the TCP header, bulk data
transfer characteristics, subflow statistics, and various other network traffic parameters.
The data set appears to be related to network traffic analysis or intrusion detection, as it includes features
commonly used in these domains to characterize network traffic behavior. It may be used for tasks such as
traffic classification, anomaly detection, or network security analysis. The "Label" column likely contains the
ground truth labels or class labels for each flow, indicating the type of traffic or presence of any security-related
events, and the "L7Protocol" and "ProtocolName" columns provide information about the higher-level protocol
or application associated with each flow.

Objective-1:The objective is to write a MapReduce program that takes a dataset containing network traffic
information with columns including Flow.ID, Source.IP, Source.Port, Destination.IP, Destination.Port,
Protocol, and ProtocolName, and outputs the count of unique Source.IP values for each different ProtocolName.
The program should filter the results to only include the specified list of ProtocolNames (e.g. HTTP,
HTTP_PROXY, SSL, GOOGLE).
Objective:2: MapReduce program in Java to count the number of occurrences of each unique Source.IP and
Destination.IP pair
