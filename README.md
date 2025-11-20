# lib-version

A version-aware Maven library that provides the util to query the version the library during runtime.

## Usage

Add the dependency to Maven project:

    <dependency>
        <groupId>com.doda25.team11</groupId>
        <artifactId>lib-version</artifactId>
        <version>1.0.4</version>
    </dependency>

In code:

    import com.doda25.team11.version.VersionUtil;

    public class Example {
        public static void main(String[] args) {
            String version = VersionUtil.getVersion();
            System.out.println("lib-version version: " + version);
        }
    }

## Updating version

The version is defined in the pom.xml under properties -> revision:

    <properties>
        <revision>1.0.5</revision>
    ...

Each time when push.

